require 'selenium-webdriver'

def is_numeric?(cad)
  cad =~ /[[:digit:]]/
end

def searchGoogle(searchQuery, arrPages)
  txtSearch = @driver.find_element(:name, 'q')
  txtSearch.send_keys(searchQuery)
  
  sleep 3
    
  search_button = @driver.find_element(:name, 'btnG')  
  search_button.click
    
  sleep 2
  
  puts "################# Search: " << searchQuery << " ###########################"
  
  arrPages.each do | page | show_results_count(page)
  end
  
  puts "################################################################"
  
  txtSearch.clear
  
end 

def  show_results_count(page)

   puts "------------------------- " + page.upcase + " TAB ----------------------"
   @driver.find_element(:xpath, './/a[text()="'+ page +'"]').click
   sleep 3
   result = @driver.find_element(:id, 'resultStats')
   puts "Result: " + getNumber(result.text)
   puts "-----------------------------------------------------"

end

def getNumber(result)

  flag = true
  
  number = result
  number = number.slice(0,number.index('(')-1)

  while(flag)
  
    number = number.slice(number.index(" ")+1,number.length-1)
  
    if(is_numeric?(number.slice(0)))
    
          flag = false
    
    end    
  
  end
  
  return number.slice(0, number.index(" "));
  
end

class SearchInGoogle

  @driver = Selenium::WebDriver.for :firefox
  @driver.navigate.to 'http://google.com.pe/'
  @driver.manage().window().maximize()
  
  arrSearches = Array.new()
  arrSearches.push('puppies')
  arrSearches.push('rats')
  
  arrPages = Array.new()
  arrPages.push('Vídeos')
  arrPages.push('Noticias')
  
  arrSearches.each do | searchQuery | searchGoogle(searchQuery,arrPages)  
  end
  
  @driver.quit
  
end