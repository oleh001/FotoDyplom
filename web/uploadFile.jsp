<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 03.07.2016
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<%@ page import="configuration.Configure" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.net.URL" %>
<%@ page import="javax.swing.*" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="model.LoadFotoThread" %>

<%
    File file;

    int maxFileSize = 10000 * 1024;
    int maxMemSize = 10000 * 1024;
    ServletContext context = pageContext.getServletContext();
    String filePath = context.getInitParameter("file-upload");

    // Verify the content type
    String contentType = request.getContentType();

    if ((contentType.indexOf("multipart/form-data") >= 0)) {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>JSP File upload</title>");
//            out.println("</head>");
//            out.println("<body>");
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);

                    Configure conf = Configure.getConfigure();
                    conf.setFoto_original_path(filePath + fileName);
                    conf.setFoto_original_name(fileName);
                    BufferedImage image = ImageIO.read(new File(filePath + fileName));
                    conf.setFoto_original_width(image.getWidth());
                    conf.setFoto_true(true);
                    out.println("Uploaded Filename: " + filePath + fileName + "<br>");
                }
            }
            //out.println("</body>");
            //out.println("</html>");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    } else {
        Configure conf = Configure.getConfigure();
        conf.setFoto_true(false);
        conf.setFoto_original_path("Plik  ma więcej 5MB");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet upload</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<p>No file uploaded</p>");
//        out.println("</body>");
//        out.println("</html>");
    }

   // LoadFotoThread loadFotoThread = new LoadFotoThread();
//    loadFotoThread.join();

    response.sendRedirect("index.jsp");
//    request.getRequestDispatcher("index.jsp").forward(request, response);
%>