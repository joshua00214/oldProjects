from bs4 import BeautifulSoup
import requests
from subprocess import Popen
import webbrowser
import urllib
import urllib.parse
import urllib.request
import time
firefox_path="C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"
webbrowser.register('firefox', None,webbrowser.BackgroundBrowser(firefox_path),1)
used = []
def reload(usedd):
    alreadyUsed = True
    r = requests.get("http://star102cleveland.cbslocal.com/playlist/") #this must be done to collect its data
    theSoup = BeautifulSoup(r.text, "html.parser")
    #print(theSoup.prettify())
    allFound = theSoup.find_all("img", class_="item-album-art")
    #print(allFound[0]['title'])
    for e in allFound:
        if alreadyUsed == False:
            break
        alreadyUsed = False
        for i in used:
            
            if alreadyUsed == True:
                break
            if e['title'] == i:
                alreadyUsed = True
            else:
                continue
        if alreadyUsed == False:
            whatToSearch = e['title']
            
                
    if whatToSearch:
        openY(whatToSearch)
def minToSec(minutes):

    a,b = minutes.split(":")
   
    return int(a) * 60 + int(b)
def openY(text):
    used.append(text)
    textToSearch = text
    query = urllib.parse.quote(textToSearch)
    url = "https://www.youtube.com/results?search_query=" + query
    response = urllib.request.urlopen(url)
    html = response.read()
    soupY = BeautifulSoup(html)
    times = soupY.findAll("span", class_="accessible-description")
    #print(time[0].string)
    newTime = times[0].string.split("- Duration: ")
    #print(newTime[1])
    newTime[1] =  newTime[1].replace(".", "" )
    finalTime = minToSec(newTime[1])
    
    youtubeLinks = soupY.findAll("a", dir="ltr")
   # print(youtubeLinks[0]['href'])
    print(webbrowser._browsers)
    webbrowser.get("firefox").open_new_tab("https://www.youtube.com" + youtubeLinks[0]['href'])
    #time.sleep(int(finalTime))
    time.sleep(int(finalTime))
    Popen('taskkill /F /IM firefox.exe')
    reload(text)
#, class_="yt-uix-tile-link yt-ui-ellipsis yt-ui-ellipsis-2 yt-uix-sessionlink      spf-link "




r = requests.get("http://star102cleveland.cbslocal.com/playlist/") #this must be done to collect its data
theSoup = BeautifulSoup(r.text, "html.parser")
#print(theSoup.prettify())
allFound = theSoup.find_all("img", class_="item-album-art")
#print(allFound[0]['title'])
print(len(allFound[0]))
whatToSearch = allFound[0]['title']
openY(whatToSearch)


