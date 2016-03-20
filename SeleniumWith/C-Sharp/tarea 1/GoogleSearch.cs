using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.Support.UI;

namespace tarea.test
{
    class GoogleSearch
    {

        private static IWebDriver driver = null;
        private static String url = "http://www.google.com.pe";
        private static Util util = new Util();

        private static void doSearch(String searchQuery, String[] arrPages)
        {

            driver.Navigate().GoToUrl(url);

            IWebElement txtSearch = driver.FindElement(By.Name("q"));

            txtSearch.SendKeys(searchQuery);

            util.sleep(2500);

            IWebElement btnSearch = driver.FindElement(By.Name("btnG"));

            btnSearch.Click();

            util.sleep(1500);

            util.printMessage("################# Search: " + searchQuery + " ###########################");

            for (int i = 0; i < arrPages.Length; i++)
            {

                show_results_count(arrPages[i]);

            }

            util.printMessage("##############################################################################");


            }


        private static void show_results_count(String page)
        {

            util.printMessage("--------------------------- " + page.ToUpper() + " TAB ---------------------------------------");
            driver.FindElement(By.XPath(".//a[text()='"+ page +"']")).Click();
            util.sleep(3000);
            IWebElement results = driver.FindElement(By.Id("resultStats"));
            util.printMessage("Results: " + util.getNumber(results.Text));
            util.printMessage("------------------------------------------------------------------------------");

        }
        
        static void Main(String[] args)
        {
            // TODO Auto-generated method stub

            driver = new FirefoxDriver();

            String[] arrSearches = { "puppies", "rats" };
            String[] arrPages = { "Vídeos", "Noticias" };
	    
	         for (int i = 0; i<arrSearches.Length; i++) {

                   doSearch(arrSearches[i], arrPages);

             }

            driver.Close();

	    }

    }
    
}
