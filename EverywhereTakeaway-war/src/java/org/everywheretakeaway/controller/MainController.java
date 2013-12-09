/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.everywheretakeaway.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.everywheretakeaway.configuration.Configuration;
import org.everywheretakeaway.context.ContextObjectFactory;
import org.everywheretakeaway.context.RequestObject;
import org.everywheretakeaway.context.ResponseAndView;
import org.everywheretakeaway.exception.EverywhereTakeawayException;

/**
 *
 * @author Fede
 */
public class MainController extends HttpServlet {
    
    
    private static final Logger logger = Logger.getLogger(MainController.class.getName());
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        
        RequestObject requestObject = ContextObjectFactory.getRequestObject(request);
        
        // File upload exception
        if(requestObject.getRequestCommmand().equals("upload_photo"))
            uploadPhoto(request, requestObject);
        
        Action action = ActionFactory.createAction(requestObject);
                
        ResponseAndView responseObject = action.createResponseAndView(requestObject);
        
        logger.info("Invocato action: "+action.getClass().getName());
        
        // Logout exception
        if(requestObject.getRequestCommmand().equals("logout"))
            request.getSession().invalidate();

        
        dispatchView(request, response, responseObject);
        
        
    }
    
    private void dispatchView(HttpServletRequest request, HttpServletResponse response, ResponseAndView responseObject) throws ServletException, IOException {
    
        String view = responseObject.getView();
        
        String resultPage = Configuration.getViewPage(view);
        
        if(resultPage == null)
            throw new EverywhereTakeawayException(EverywhereTakeawayException.ACTION_ERROR, "Non ci sono view configurate con il nome " + view);
        
        //logger.log(Level.INFO, "View path: " + resultPage);
        
        ViewDispatcher dispatcher = new ViewDispatcher(request.getRequestDispatcher(resultPage));
        
        dispatcher.forward(request, response, responseObject);
    
    
    
    }
    
    public void uploadPhoto(HttpServletRequest request, RequestObject requestObject) {
    
        String imagesDirectory = "img";
        String uploadDirectory = getServletContext().getRealPath(imagesDirectory);
        String fileName = "";
        
        //process only if its multipart content and the user is logged in
        if(ServletFileUpload.isMultipartContent(request) && (request.getSession().getAttribute("email") != null)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        //String name = new File(item.getName()).getName();
                        fileName = String.valueOf((Long)(request.getSession().getAttribute("id"))) + "." + FilenameUtils.getExtension(item.getName());
                        File file = new File(uploadDirectory + File.separator + fileName);
                        
                        // Se esiste già lo cancello
                        if(file.exists())
                            file.delete();
                        
                        item.write(file);
                    }
                }

               //File uploaded successfully
               requestObject.setValue("esito_upload", "true");
               requestObject.setValue("img_path", imagesDirectory + "/" + fileName);
            } catch (Exception ex) {
               requestObject.setValue("esito_upload", "File Upload Failed due to " + ex);
            }          

        }else{
            request.setAttribute("esito","Fail");
        }


    
    }
    
    public void init(ServletConfig config) throws ServletException {
        
        Configuration.init(config);
        super.init(config);
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
