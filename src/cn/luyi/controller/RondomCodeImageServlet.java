package cn.luyi.controller;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fleming Start
 */
public class RondomCodeImageServlet extends HttpServlet {

    private final int width = 60;
    private final int height = 20;
    private final String charset = "1234567890abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public RondomCodeImageServlet() {
        super();
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        try {

            BufferedImage bufferedImage = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();

            Random random = new Random();

            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height); // ÃÓ≥‰±≥æ∞

            graphics.setColor(Color.GRAY);
            graphics.drawRect(0, 0, width - 1, height - 1); // ªÊ÷∆±ﬂøÚ

            // …˙≥…∏…»≈œﬂ
            graphics.setColor(new Color(169, 169, 169));
            for (int i = 1; i <= 30; i++) {

                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int xwidth = random.nextInt(20);
                int yheight = random.nextInt(20);

                graphics.drawLine(x, y, xwidth, yheight);
            }

            Font font = new Font("Courier New", Font.BOLD, 18);
            graphics.setFont(font);
            int red;
            int green;
            int blue;

            char[] codeSource = charset.toCharArray(); // —È÷§¬Î‘¥
            int length = codeSource.length;

            StringBuffer randomCode = new StringBuffer(); // ”√”⁄¥Ê¥¢ÀÊª˙◊÷∑˚
            for (int i = 0; i < 5; i++) {

                String code = String
                        .valueOf(codeSource[random.nextInt(length)]);
                red = random.nextInt(110);
                green = random.nextInt(50);
                blue = random.nextInt(50);
                graphics.setColor(new Color(red, green, blue));
                graphics.drawString(code, 10 * i + 8, 16);
                randomCode.append(code);
            }

            // Ω´—È÷§¬Î◊÷∑˚¥Æ–¥»Îsession
            HttpSession session = request.getSession();
            session.setAttribute("randomCode", randomCode.toString());
            graphics.dispose();

            // Ω˚÷πÕºœÒª∫¥Ê
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            response.setContentType("image/jpeg");
            ServletOutputStream sos = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpeg", sos);

        } finally {
//            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}