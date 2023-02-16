package controller;

import service.IPlayListService;
import service.impl.PlayListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PlayListServlet", value = "/PlayListServlet")
public class PlayListServlet extends HttpServlet {
    private IPlayListService playListService = new PlayListService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("playList", playListService.findAllPlayList());
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
