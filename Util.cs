using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace tarea.test
{
    class Util
    {

        public void sleep(int millis)
        {

            Thread.Sleep(millis);

        }

        public void printMessage(String message)
        {

            Console.WriteLine(message);

        }

        public String getNumber(String result)
        {

            bool flag = true;

            String number = result.Substring(0, result.IndexOf('(') - 1);

            while (flag)
            {

                number = number.Substring(number.IndexOf(" ") + 1, number.Length);

                if (Char.IsDigit(number[0]))
                {

                    flag = false;

                }

            }

            return number.Substring(0, number.IndexOf(" "));

        }

    }
}
