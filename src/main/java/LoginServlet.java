import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();

        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        // hvis bruger map er tomt så er det den første bruger
        if (servletContext.getAttribute("brugerMap") == null) {


            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test","test");

            servletContext.setAttribute("brugerMap", brugerMap);

        }

        // hvis brugernavnet ikke findes
        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            //todo gå til login side
            request.setAttribute("besked", "brugernavnet findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request, response);


        }


        // hvis det er rigtig kode goto huskeliste
        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            // todo gå til huskelisten
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request, response);

        }


        // forkert kode
        // todo gå til login side dvs index siden.
            request.setAttribute("besked", "din kode var forkert, prøv igen");
            request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
