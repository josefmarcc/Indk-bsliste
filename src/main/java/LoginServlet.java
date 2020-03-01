import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletContext servletContext = getServletContext();

        // henter session scopet
        HttpSession session = request.getSession();




        String navn = request.getParameter("navn");
        String kodeord = request.getParameter("kodeord");

        // hvis bruger map er tomt så er det den første bruger
        if (servletContext.getAttribute("brugerMap") == null) {


            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test","test");
            brugerMap.put("admin","1234");

            servletContext.setAttribute("brugerMap", brugerMap);

        }

        if( ( (Set<String>) servletContext.getAttribute("aktiveBrugere")) == null ){

            Set<String> aktiveBrugere = new HashSet<>();
            servletContext.setAttribute("aktiveBrugere", aktiveBrugere);


        }





            // hvis brugernavnet ikke findes
        if (!((Map<String, String>) servletContext.getAttribute("brugerMap")).containsKey(navn)) {

            //todo gå til login side
            request.setAttribute("besked", "Opret dig som bruger");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request, response);


        }


        // hvis det er rigtig kode goto huskeliste
        if (((Map<String, String>) servletContext.getAttribute("brugerMap")).get(navn).equalsIgnoreCase(kodeord)) {

            //hvis brugernavn er admin og kode er rigtig
            if (navn.equalsIgnoreCase("admin")){
                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
            }

            if( !( (Set<String>) servletContext.getAttribute("aktiveBrugere")).contains(navn)){

                ((Set<String>) servletContext.getAttribute("aktiveBrugere")).add(navn);

                session.setAttribute("besked", "du logget ind med brugernavnet #" + navn);
                request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request, response);

            }

        }
        // hvis koden er forkert
            request.setAttribute("besked", "Der gik et eller andet galt, prøv igen");
            request.getRequestDispatcher("index.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
