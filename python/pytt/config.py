#!/usr/bin/env python
# -*- coding: utf-8 -*-
'''
配置文件
'''
class Config(object):
    JOBS = [
        {
            'id': 'job',
            'func': 'jobs:job',
            'args': '',
            'trigger': 'interval',
            'seconds': 120  # 抓取数据时间 120s 2分钟
        }
    ]

    SCHEDULER_API_ENABLED = True

    URL = {
        'jj':'http://fund.eastmoney.com/'#天天基金
    }





