# -*- coding: utf-8 -*-

from bs4 import BeautifulSoup
import logging
logger = logging.getLogger('job')


'''解析基金'''
def parst_jj():
    try:
        logger.debug('开始解析基金数据文件')
        file = open('./pages/jj.html')
        soup = BeautifulSoup(file,'lxml')
        table = soup(id='tb_jjcs')[0]
        thead_ths = table('th', text='操作')
        for th in thead_ths:
            th.decompose()
        tbody_tds = table('td',class_='widthBTN')
        for td in tbody_tds:
            td.decompose()
        links = table('a')
        for link in links:
            del link['href']
        table.tfoot.decompose()
        #print(table.prettify())
        str = ''
        with open('./data/jj.txt','w') as fb:
            str += table.prettify()
            fb.write(str)
            fb.close()
        logger.debug('解析基金数据完成')
    except FileNotFoundError:
        logger.debug('解析基金数据文件失败，文件不存在')
    except Exception as e:
        logger.error('解析基金数据错误',exc_info=True)

