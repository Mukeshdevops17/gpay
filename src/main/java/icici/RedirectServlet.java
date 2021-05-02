package icici;

/**
 * @(#)DBServlet.java 0.00 12-Feb-97 Don Corley
 *
 * Copyright (c) 2009 tourapp.com. All Rights Reserved.
 *      don@donandann.com
 */

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RedirectServlet
 * 
 * This servlet is the redirect servlet.
 */
public class RedirectServlet extends BaseServlet
{
	private static final long serialVersionUID = 1L;

	public static final String TARGET = "target";
    public static final String DEFAULT_TARGET_URL = "http://www.jbundle.org";

    /**
     * returns the servlet info
     */ 
    public String getServletInfo()
    {
        return "This the redirect servlet";
    }
    /**
     * init method.
     * @exception ServletException From inherited class.
     */
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
    /**
     * Destroy this Servlet and any active applications.
     * This is only called when all users are done using this Servlet.
     */
    public void destroy()
    {
        super.destroy();
    }
    /**
     *  process an HTML get or post.
     * @exception ServletException From inherited class.
     * @exception IOException From inherited class.
     */
    public void service(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException
    {
//      super.service(req, res);
        String strBrowser = this.getBrowser(req);
        String strParams = req.getQueryString();
        String strTarget = this.getInitParameter(strBrowser);
        if (strTarget == null)
            strTarget = this.getInitParameter(TARGET);
        if (strTarget == null)
            strTarget = req.getParameter(TARGET);
        if ((strTarget == null) || (strTarget.length() == 0))
            strTarget = DEFAULT_TARGET_URL;
        if (strParams != null)
        {
            char chDelim = '?';
            if (strTarget.indexOf('?') != -1)
                chDelim = '&';
            strTarget = strTarget + chDelim + strParams;
        }

        res.sendRedirect(strTarget);
    }
}
