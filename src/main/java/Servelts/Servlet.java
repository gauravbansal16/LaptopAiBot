package Servelts;

import ai.api.model.AIContext;
import ai.api.model.AIResponse;
import ai.api.model.Result;
import examples.Actions;
import examples.TextClientApplication;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gaurav on 16/01/17.
 */
@WebServlet(name="Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        TextClientApplication tca=new TextClientApplication();
        List<String> replies=new ArrayList<String>();
        AIResponse reply=tca.responder(request.getParameter("request"), (List<AIContext>) request.getSession().getAttribute("Context"));


        if (reply.getStatus().getCode() == 200) {
            Result result=reply.getResult();
            //System.out.println(action);
            Actions actions=new Actions(result);
            String customResponse=actions.run();
            replies.add(customResponse);
            replies.add(reply.getResult().getFulfillment().getSpeech());
        }

        else {
            System.err.println(reply.getStatus().getErrorDetails());
        }


        request.setAttribute("reply",replies);
        request.getSession().setAttribute("Context",reply.getResult().getContexts());
        RequestDispatcher rd=request.getRequestDispatcher("chatreply.jsp");
        rd.forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getSession().setAttribute("Context",null);
        RequestDispatcher rd=request.getRequestDispatcher("chatWindow.jsp");
        rd.forward(request,response);
    }
}
