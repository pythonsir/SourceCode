#!/usr/bin/env python3
# -*- coding: utf-8 -*-
from flask import Flask,render_template
from flask_apscheduler import APScheduler
from config import Config
import time
import logging
import logging.config
logging.config.fileConfig('logging.conf')


app = Flask(__name__)
app.config.from_object(Config())

@app.route('/jj.html')
def getjj():
    html = ''
    with open('./data/jj.txt','r') as o:
        html = o.read()
        o.close()
    return render_template('jj.html',content=html,title='基金超市偏股型')


if __name__ == '__main__':
    sche = APScheduler()
    sche.api_enabled = True
    sche.init_app(app)
    sche.start()
    app.run()


