import os
import requests
from bs4 import BeautifulSoup
import youtube_dl
from selenium import webdriver
import time
from selenium.webdriver.chrome.options import Options
import sys
import _thread

headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'}

chrome_options = Options()  
#chrome_options.add_argument("--window-size=0,0")
#chrome_options.add_argument("--headless")  
def getSongName():
    
    songName = input("Enter song to download, or type 'exit' to exit program: ")
    if songName == "exit":
        sys.exit(0)
    songName = songName.replace(" ", "+")
    #_thread.start_new_thread(downloadSong,  (songName,))
    downloadSong(songName)
    getSongName()
    
def downloadSong(sname):
    sName = sname
    firstYoutube = requests.get("https://www.youtube.com/results?search_query=" + sName, headers) #add song here with space between, the headers doesn't do anything
    #print(firstYoutube.status_code) # should print 200, saying it works

    firstYoutubeSite = BeautifulSoup(firstYoutube.content, 'html.parser') #create beautifulSoup
    correctA = firstYoutubeSite.find_all("a",dir="ltr")[1] #search for the a tag, its not the same file chrome has so that why it uses dir="ltr"

    #print("https://www.youtube.com" + correctA["href"])

    entireLink = "https://www.youtube.com" + correctA["href"]

    #print(correctA["href"][9:])
    neededLink = (correctA["href"][9:])



    convert = requests.get("https://ytmp3.com/download/" + neededLink, timeout= 10, stream = True)

    convertBS = BeautifulSoup(convert.content, "html.parser")


    driver = webdriver.Chrome(executable_path="chromedriver", chrome_options=chrome_options)
    driver.get("https://ytmp3.com/download/" + neededLink)
    convertBS = BeautifulSoup(driver.page_source, "html.parser")
    print(convertBS.find_all("a", id="progress-bar"))
    old = "1"
    while(True):
        try:
            convertBS = BeautifulSoup(driver.page_source, "html.parser")
            href = convertBS.find_all("a", id="progress-bar")[0]
            if(href["data-href"]):
                break
        except:
            convertBS = BeautifulSoup(driver.page_source, "html.parser")
            href = convertBS.find_all("a", id="progress-bar")[0]
            if(href["data-attr"] != old):
                print(href["data-attr"])
                old = href["data-attr"]
            
            time.sleep(.1)
        

    #driver.get("https://ytmp3.com" + href["data-href"])


    response = requests.get("https://ytmp3.com" + href["data-href"], timeout=10, stream=True)
    #print(response.content)
    #time.sleep(10)
    # Throw an error for bad status codes
    response.raise_for_status()

    with open(sName + ".mp3", 'wb') as handle:
        for block in response.iter_content(1024):
            handle.write(block)


    driver.close()
    
getSongName()


'''



       #create automated chrome

driver.get("http://www.flvto.biz/youtube-to-mp3/") #chrome connect to this site

textBox = driver.find_elements_by_id("convertUrl")[0] #get the search element id
textBox.clear()         #clear search field
textBox.send_keys(entireLink)         #send the youtube address
textBox.send_keys(Keys.RETURN)
while(True):

    try:
        textBox.find_elements_by_id
    except e, a:
        print()

input("done")
'''

