import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UploadPhotoServlet")
public class UploadPhotoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为1M
            factory.setSizeThreshold(1024*1024);

            List items = null;
            try{
                items = sfu.parseRequest(request);
            }catch (FileUploadException e){
                e.printStackTrace();
            }
            Iterator iterator = items.iterator();
            while(iterator.hasNext()){
                FileItem item = (FileItem) iterator.next();
                if(!item.isFormField()){
                    // 根据时间戳创建头像文件
                    fileName = System.currentTimeMillis()+".jpg";
                    //通过getRealPath获取上传文件夹，如果项目在e:/MyMVN/web,那么就会自动获取到 e:/MyMVN/web/uploaded
                    String photoFolder = request.getServletContext().getRealPath("uploaded");
                    File file = new File(photoFolder,fileName);
                    file.getParentFile().mkdirs();
                    InputStream inStream = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(file);

                    byte[] b = new byte[1024*1024];
                    int len = 0;
                    while((len = inStream.read(b))!=-1){
                        out.write(b,0,len);
                    }
                    out.close();
                }else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(value);
                }
            }

            String html = "<img width='200' height='150' src='uploaded/%s' />";
            response.setContentType("text/html");
            PrintWriter pw= response.getWriter();

            pw.format(html, fileName);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
