import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Tài", "2004-02-06", "Huế", "https://upload.wikimedia.org/wikipedia/commons/c/cc/Ngomon2.jpg"));
        customerList.add(new Customer("Diễm", "2003-02-04", "Huế", "https://upload.wikimedia.org/wikipedia/commons/c/cc/Ngomon2.jpg"));
        customerList.add(new Customer("Định", "2002-03-05", "Huế", "https://upload.wikimedia.org/wikipedia/commons/c/cc/Ngomon2.jpg"));
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list_customer.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Tài", "2004-02-06", "Huế", "https://upload.wikimedia.org/wikipedia/commons/f/fe/Son_Tung_M-TP_1_%282017%29.png"));
        customerList.add(new Customer("Diễm", "2003-02-04", "Huế", "https://ben.com.vn/tin-tuc/wp-content/uploads/2021/12/anh-che-cho-hai-huoc-cho-dien-thoai-4.jpg"));
        customerList.add(new Customer("Định", "2002-03-05", "Huế", "https://ben.com.vn/tin-tuc/wp-content/uploads/2021/12/anh-che-cho-hai-huoc-cho-dien-thoai-4.jpg"));
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list_customer.jsp");
        requestDispatcher.forward(request, response);
    }
}
