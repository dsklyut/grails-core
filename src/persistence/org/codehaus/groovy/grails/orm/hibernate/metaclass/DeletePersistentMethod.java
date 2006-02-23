/*
 * Copyright 2004-2005 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 
package org.codehaus.groovy.grails.orm.hibernate.metaclass;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 
 * 
 * @author Steven Devijver
 * @author Graeme Rocher
 * 
 * @since Aug 7, 2005
 */
public class DeletePersistentMethod extends AbstractDynamicPersistentMethod {

    public static final String METHOD_SIGNATURE = "delete";

    public DeletePersistentMethod(SessionFactory sessionFactory, ClassLoader classLoader) {
        super(METHOD_SIGNATURE,sessionFactory, classLoader);
    }

    protected Object doInvokeInternal(Object target, Object[] arguments) {
        HibernateTemplate t = getHibernateTemplate();
        t.setFlushMode(HibernateTemplate.FLUSH_COMMIT);
        t.delete(target);
        return null;
    }

}
