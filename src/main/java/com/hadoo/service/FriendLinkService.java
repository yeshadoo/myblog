package com.hadoo.service;

import com.hadoo.model.FriendLink;
import com.hadoo.utils.DataMap;

/**
 * @author: zhangocean
 * @Date: 2019/5/16 17:08
 * Describe:
 */
public interface FriendLinkService {

    DataMap addFriendLink(FriendLink friendLink);

    DataMap getAllFriendLink();

    DataMap updateFriendLink(FriendLink friendLink, int id);

    DataMap deleteFriendLink(int id);

    DataMap getFriendLink();
}
