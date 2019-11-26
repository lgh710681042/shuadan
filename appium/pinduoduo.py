from appium import webdriver

#基础配置
desired_caps = {
    'platformName': 'Android',  # 平台
    'deviceName': "小米手机",  # 手机设备名称
    'platformVersion': "5.0.2",  # 安卓系统版本号
    'appPackage': 'com.xunmeng.pinduoduo',  # apk包名
    'appActivity': 'com.xunmeng.pinduoduo.ui.activity.MainFrameActivity',  # apk activity
    'unicodeKeyboard': True,  # 设置编码格式为unicode
    'resetKeyboard': True,  # 隐藏手机键盘
    'noReset': True  # 非初始化
}

driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_caps)  # 启动app
sleep(5)