package htmlUnit;

import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


/**
 * Classe per il test di HtmlUnit
 * @author Francesco Faro
 *
 */
public class Test_Scrape_HtmlUnit 
{
	public static void main(String args[]) throws Exception 
	{
		String url = "https://it.wikipedia.org/wiki/Cowboy_Bebop";
		WebClient webClient = new WebClient();
		HtmlPage htmlPage = webClient.getPage(url);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false); //WARNING: Obsolete content type encountered: 'text/javascript'.
        webClient.getOptions().setDownloadImages(true);
        WebResponse response = htmlPage.getWebResponse();

		System.out.println(htmlPage.getTitleText() + "\n");

		//querySelector
		try
		{
			DomNode domNode = htmlPage.querySelector("headings");
			System.out.println(domNode.getVisibleText());

		}
		catch(Exception e)
		{
			System.out.println("-Richiesta errata; elemento non trovato-");
		}

		//recupera tutti i link all'interno del sito
		List<HtmlAnchor> anchors = htmlPage.getAnchors();
		for (HtmlAnchor anchor : anchors) {
			System.out.println(anchor.getAttribute("href") + "\n");
		}
	}//fine main
}
