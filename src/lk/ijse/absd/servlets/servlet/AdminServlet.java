package lk.ijse.absd.servlets.servlet;

import lk.ijse.absd.servlets.dto.AdminDTO;
import lk.ijse.absd.servlets.service.other.ServiceFactory;
import lk.ijse.absd.servlets.service.spec.AdminService;
import lk.ijse.absd.servlets.servlet.other.JsonResponseGenerator;
import lk.ijse.absd.servlets.servlet.other.PojoGenerator;
import lk.ijse.absd.servlets.util.Constaants;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {

    private AdminService adminService;

    public AdminServlet() {
        this.adminService=new ServiceFactory().getService(ServiceFactory.ServiceTypes.ADMIN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            boolean operation = req.getHeader("operation").isEmpty();
        } catch (NullPointerException n){
            resp.sendError(400,"No operation header is presented ! ");
            return;
        }
        switch (req.getHeader("operation")){
            case "authenticate":
                try {
                    AdminDTO adminDTO;
                    try {
                        adminDTO = new PojoGenerator().getAdminDTO(req.getReader());
                    } catch (NullPointerException n) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request data " + n.getMessage());
                        return;
                    }
                    adminDTO = adminService.authenticate(adminDTO);
                    if(adminDTO!=null){
                        resp.setStatus(200);
                        JsonObject forCommonResponse = new JsonResponseGenerator()
                                .getForCommonResponse(Constaants.ADDED, "Logged in !");
                        req.getSession();
                        resp.getWriter().println(forCommonResponse);
                        return;
                    }else {
                        resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials provided ! ");
                        return;
                    }
                }catch (RuntimeException r){
                    r.printStackTrace();
                    resp.sendError(HttpServletResponse.SC_EXPECTATION_FAILED,r.getMessage());
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Post Operation");
                break;
        }
    }
}
