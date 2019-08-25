# coding=utf-8
#!/usr/bin/python3

from bs4 import BeautifulSoup

import urllib.request
import ssl
import os
import re
import random
import base64

'''
获取目前url的源文件
'''
def getIndex():

    #目标url
    url = "https://activity.tuiayonghu.com/activity/index?id=9150&slotId=193506&login=normal&appKey=uuNX4GQ6Xoi9mNG2yZcz3eYBRf1&deviceId=212a63c1-0fb1-4f9b-8fcf-70bfb1a6df94&dsm=1.193506.0.0&tenter=SOW&subActivityWay=2&tck_rid_6c8=0ad021cejrhq8cb9-6019810&tck_loc_c5d=tactivity-9150&dcm=401.193506.0.0&&tenter=SOW"

    request = urllib.request.Request(url)

    #去掉ssl认证

    ssl._create_default_https_context = ssl._create_unverified_context

    with urllib.request.urlopen(request) as f:

        html = f.read()
        '''因为html读出来的是二进制，因此写入index.html也必须以二进制的形式'''
        with open('index.html','wb') as fb:
            fb.write(html)

    currpath = os.getcwd()

    if not os.path.exists(currpath+'/css'):
        os.mkdir(currpath + '/css')
    if not os.path.exists(currpath+'/images'):
        os.mkdir(currpath + '/images')

    return os.getcwd()+'/index.html'

'''获取直接页面的图片资源'''
def getIndexImage(path):
    soup = BeautifulSoup(open(path), 'lxml')
    '''获取页面中img标签'''
    imgs = soup.find_all('img')
    if len(imgs) > 0:
        #todo 保存Url图片,因为此链接的源码页面中并没有img标签，所以这里不做出来
        print()
    '''获取js变量中的img路径'''
    with open(path) as p:
        content = p.read()
        imglist = re.findall('("image":[^,]*,)',content)
        print(imglist)
        for img in imglist:
            arr = img.split(':')
            url = 'http:'+arr[1][1:-2]
            saveImage(url)
        valuelist =re.findall('("value":"//yun[^,]*,)',content)
        print(valuelist)
        for img in valuelist:
            arr = img.split(':')
            url = 'http:'+arr[1][1:-2]
            saveImage(url)

def getCssAndImage(path):
    dealCss(path)




#保存css文件
def dealCss(path):
    soup = BeautifulSoup(open(path), 'lxml')
    links = soup.find_all('link', attrs={'href': re.compile('.css')})
    '''
     保存css文件到文件夹中
    '''
    list = []
    for link in links:
        href = 'http:' + link['href']
        name = href[href.rindex('/') + 1:]
        request = urllib.request.Request(href)
        with urllib.request.urlopen(request) as u:
            css = u.read()
            with open(os.getcwd()+'/css/'+name,'wb') as f:
                f.write(css)
    '''
    通过正则表达式提取base64数据和图片路径
    '''
    dirss = os.listdir(os.getcwd()+'/css')
    for dir in dirss:
        with open(os.getcwd()+'/css/'+dir) as f:
            content = f.read()
            reglist = re.findall('(url\([^\)]*\);)',content)
            for i in reglist:
                real = i[i.index('(')+1:i.rindex(')')]
                if real.startswith("//"):
                    saveImage('http:'+real)
                else:
                    saveBase64(real)

'''将url图片路径保存为图片'''
def saveImage(url):
    name = url[url.rindex('/')+1:]
    with urllib.request.urlopen(url) as i:
        content = i.read()
        with open(os.getcwd()+'/images/'+name,'wb') as f:
            f.write(content)
            print('保存图片：'+name+'\n')

'''将base64的编码转换为图片格式'''
def saveBase64(code):
    rc = re.search('data:image\/[a-z]+;',code).group()
    ext = '.'+rc[rc.rindex('/')+1:-1]
    name = ''.join(random.sample(['z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'], 8))
    seq = re.search('data:image\/[a-z]+\;base64,',code).span()
    print(seq)
    newcode = code.replace(code,code[seq[1]:-1])
    print(newcode+'\n')
    with open(os.getcwd()+'/images/'+name+ext,'wb') as f:
        if len(newcode) % 4 != 0:  # check if multiple of 4
            while len(newcode) % 4 != 0:
                newcode = newcode + "="
            req_str = base64.b64decode(newcode)
        else:
            req_str = base64.b64decode(newcode)
        f.write(req_str)

def main():
    source = getIndex()
    getIndexImage(source)
    getCssAndImage(source)

if __name__ == '__main__':

    main()








