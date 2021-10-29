package htmlUnit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


/**
 * Classe per il test di HtmlUnit
 * @author Francesco Faro
 *
 */
public class Test_Scrape_HtmlUnit 
{
	public static void main(String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException 
	{
		String url = "https://it.wikipedia.org/wiki/Cowboy_Bebop";
		WebClient webClient = new WebClient();
		HtmlPage htmlPage = webClient.getPage(url);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false); //WARNING: Obsolete content type encountered: 'text/javascript'.
		webClient.getOptions().setDownloadImages(false);
		//final HtmlDivision div = htmlPage.getHtmlElementById("");
		WebResponse response = htmlPage.getWebResponse();

		System.out.println(htmlPage.getTitleText() + "\n");

		//querySelector
		try
		{
			DomNode domNode = htmlPage.querySelector("script > src"); //("html") recupera tutto il file html del sito
			System.out.println(domNode.getVisibleText());

		}
		catch(Exception e)
		{
			System.out.println("-Richiesta errata; elemento non trovato-");
		}

		//recupera tutti i link all'interno del sito
		final List<HtmlAnchor> anchors = htmlPage.getAnchors();
		for (HtmlAnchor anchor : anchors) 
		{
			System.out.println(anchor.getAttribute("href") + "\n");
		}

		//recupera tutti i link all'interno del sito
		final List<HtmlImage> images = htmlPage.getByXPath("//img");
		for (HtmlImage image : images) 
		{
			HtmlImage img = (HtmlImage) image;
			System.out.println(image.getSrcAttribute() + "\n");
		}

//		try 
//		{
//			DomNodeList<DomElement> list =  htmlPage.getElementsByTagName("script");
//			for(DomElement t : list)
//			{
//			System.out.println(t.getAttribute("src"));
//
//			}
//		} catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
		
		try 
		{
			DomNodeList<DomElement> list =  htmlPage.getElementsByTagName("script");
			for(DomElement t : list)
			{
			System.out.println(t.toString()); // asXlm(); getScriptableElement(); toString()

			}
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("NOPE");
		}

	}//fine main
}
