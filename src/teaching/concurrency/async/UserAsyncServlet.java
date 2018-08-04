package teaching.concurrency.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/user"}, asyncSupported = true)
public class UserAsyncServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {

        final AsyncContext context = request.startAsync();
        context.start(new Runnable() {
            public void run() {
                // make the network call
                ServletResponse response = context.getResponse();
                // print to the response
                context.complete();
            }
        });
    }
}
