package teaching.concurrency.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user"}, asyncSupported = true)
public class UserAsyncServlet_2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        final AsyncContext context = request.startAsync();
        ServletInputStream input = request.getInputStream();
//        input.setReadListener(new MyReadListener(input, context));

    }
}
