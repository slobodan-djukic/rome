/*
 * Copyright 2004 Sun Microsystems, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.sun.syndication.feed.synd.impl;

import com.sun.syndication.feed.rss.Item;
import com.sun.syndication.feed.synd.SyndEntry;

import java.util.Date;

/**
 */
public class ConverterForRSS093 extends ConverterForRSS092 {

    public ConverterForRSS093() {
        this("rss_0.93");
    }

    protected ConverterForRSS093(String type) {
        super(type);
    }

    protected SyndEntry createSyndEntry(Item item, boolean preserveWireItem) {
        SyndEntry syndEntry = super.createSyndEntry(item, preserveWireItem);
        Date pubDate = item.getPubDate();
        if (pubDate!=null) {
            syndEntry.setPublishedDate(pubDate);     //c
        }
        return syndEntry;
    }

    protected Item createRSSItem(SyndEntry sEntry) {
        Item item = super.createRSSItem(sEntry);
        item.setPubDate(sEntry.getPublishedDate());        //c
        return item;
    }

}
