import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class MyServlet extends HttpServlet {
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";

    /**
     * Метод POST
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";
        HttpSession session = request.getSession();
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        User user = new User(firstName, lastName);

        request.setAttribute("user", user);
        session.setAttribute(firstName, lastName);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Метод GET
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
