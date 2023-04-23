package com.jomkie.spring.namespacehandler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 自定义命名空间处理器
 */
class JomkieNamespaceHandler extends NamespaceHandlerSupport {

    public JomkieNamespaceHandler() {}

    @Override
    public void init() {
        registerBeanDefinitionParser("jolabel", new JoLabelBeanDefinitionParser());
    }

}
