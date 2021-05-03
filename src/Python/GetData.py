import urllib.request
import urllib.parse
import http.cookiejar
import getpass
import os
import json
from lxml import etree  # path = './web/new_index.html'

def saveFile(content, path, filename):
    '''
    功能：将文章内容 content 保存到本地文件中
    参数：要保存的内容，路径，文件名
    '''
    # 如果没有该文件夹，则自动生成
    if not os.path.exists(path):
        os.makedirs(path)

    # 保存文件
    with open(path + filename, 'w', encoding='GBK') as f:
        f.write(str(content))


def getHtml():
    # http.cookiejar 该包是专门对网页的cookie只进行获取的
    # cookiejar是专门让代码保存cookie值
    # 创建一个cookiejar对象
    cookiejar = http.cookiejar.CookieJar()
    # 根据cookiejar创建一个管理器对象
    handler = urllib.request.HTTPCookieProcessor(cookiejar)
    # 在使用handler创建一个opener对象对服务器发送请求
    opener = urllib.request.build_opener(handler)

    url = "http://kdjw.hnust.edu.cn/jsxsd/xk/LoginToXk"
    headers = {
        "User-Agent": " Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"
    }
    # id=input("input id:")
    # password=input("input password:")
    #userAccount = input('请输入教务网账号:')
    #userPassword = input('请输入教务网密码:')
    data = {
        #"userAccount": userAccount,
        #"userPassword": userPassword,
        "userAccount": '1805040105',
        "userPassword": '1913394899a',
        "encoded": 'MTgwNTA0MDEwNQ==%%%MTkxMzM5NDg5OWE='
    }
    data = urllib.parse.urlencode(data).encode("gbk")
    request = urllib.request.Request(url, headers=headers)
    # response = urllib.request.urlopen(request,data=data)

    response = opener.open(request, data=data)
    # 显示的结果是一个含登录信息的网页地址
    # print(response.read().decode("utf8"))

    # 显示结果：
    # {"code":true,"homeUrl":"http://www.renren.com/home"}

    # 获取登录时的cookie值
    # 登录后访问其他含登录信息的网页时，必须带着cookie

    get_url = "http://kdjw.hnust.edu.cn/jsxsd/xskb/xskb_list.do"
    request = urllib.request.Request(get_url, headers=headers)

    # opener对象保存了登录时的cookie值
    # 再次更换请求对象使用opener进行请求时，cookie还是存在的，能够保存登录信息
    response1 = opener.open(request)
    html = response1.read().decode()
    #print(html)
    content = html
    path="C:/WorkSpace/Java/FreeTableAndRoadRecommandation/src/Data/"
    fileName = 'CourseTable.html'
    saveFile(content, path, fileName)


def decodeHtml():
    fp = open('C:/WorkSpace/Java/FreeTableAndRoadRecommandation/src/Data/CourseTable.html','rb')
    html = fp.read().decode('gbk')   #.decode('gbk')
    # print(html)
    selector = etree.HTML(html)   #etree.HTML(源码) 识别为可被xpath解析的对象
    #class='kbcontent'
    infos= selector.xpath("//div[@class='kbcontent']//text()")
    #str(infos).replace('\xa0', '  ')
    path="C:/WorkSpace/Java/FreeTableAndRoadRecommandation/src/Data/"
    #fileName = 'infos.json'
    fileName = 'infos1-1.txt'
    content=''
    #添加逗号，便于分割
    i=0
    for info in infos:
        info=info+' '
        if(info=='\xa0 '):
            info='free '+str(i)+' \n'
            i=(i+1)%7
        if(info.find('讲课:')!=-1):
            info=info+str(i)+' \n'
            i=(i+1)%7
        if(info.find('------')!=-1):
            info=''
            i=i-1
        if(info.find('(周)')!=-1):
            info=info.split(')')[0]+') '+info.split(')')[1]
        print(info)
        #content = str(infos).replace(u'\xa0', u'free')

        content = content+info

    #进行“行”划分，借助特征数据“讲课:”
    #如何把parallel处理好？
    #saveAsJsonFile(content, path, fileName)
    saveFile(content, path, fileName)

def saveAsJsonFile(content,path,filename):
    if not os.path.exists(path):
        os.makedirs(path)

    # 保存文件
    with open(path + filename,'w') as f:
        json.dump(content,f)

if __name__ == '__main__':
    '''
    主函数：程序入口
    '''
    print("hello")
    getHtml()
    decodeHtml()
#1805040105
#1913394899a