
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hi")
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init() {
        System.out.println(">>> init(): Servlet ka object bana");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        System.out.println(">>> doGet(): request aayi");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println("<h1>Hello World!</h1>");
        resp.getWriter().println("<p>I am learning java</p>");
    }

    @Override
    public void destroy() {
        System.out.println(">>> destroy(): Servlet band ho raha hai");
    }
}
