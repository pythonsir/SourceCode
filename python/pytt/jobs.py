# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import logging
from pytt import app
import parse

logger = logging.getLogger('job')

'''
执行定时任务
'''
def job():
    logger.debug('定时器开始执行')
    logger.debug('开始抓取数据')
    option = webdriver.FirefoxOptions()
    option.headless = True
    driver = webdriver.Firefox(options=option, service_log_path='./log/geckodriver.log')
    try:
        driver.get(app.config.get('URL')['jj'])
        WebDriverWait(driver, 10).until(
            EC.visibility_of_element_located((By.ID, 'tb_jjcs'))
        )
        html = driver.page_source
        with open('./pages/jj.html', 'w') as fb:
            fb.write(html)
            fb.close()
            logger.debug('抓取天天基金网数据完成')
    except Exception as e:
        logger.error('失败！抓取天天基金网数据',exc_info=True)
    finally:
        driver.quit()
        logger.debug('开始解析所有抓取数据')
    parse.parst_jj()
    logger.debug('定时器开始完成')


