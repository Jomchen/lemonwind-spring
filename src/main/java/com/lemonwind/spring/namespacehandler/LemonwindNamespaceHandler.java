package com.lemonwind.spring.namespacehandler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义命名空间处理器
 */
class LemonwindNamespaceHandler extends NamespaceHandlerSupport {

    public LemonwindNamespaceHandler() {}

    @Override
    public void init() {
        registerBeanDefinitionParser("jolabel", new JoLabelBeanDefinitionParser());
    }

}
