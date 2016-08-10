package core.dht.msg.req;

import core.dht.msg.Msg_base;

/**
 * 
 *ping

最基础的请求就是ping。这时KPRC协议中的“q”=“ping”。Ping请求包含一个参数id，它是一个20字节的字符串包含了发送者网络字节序的nodeID。对应的ping回复也包含一个参数id，包含了回复者的nodeID。


参数: {"id"&nbsp;: "<querying nodes id>"}

回复:{"id"&nbsp;: "<queried nodes id>"}


报文包例子

ping请求={"t":"aa", "y":"q","q":"ping", "a":{"id":"abcdefghij0123456789"}}

B编码=d1:ad2:id20:abcdefghij0123456789e1:q4:ping1:t2:aa1:y1:qe

回复={"t":"aa", "y":"r", "r":{"id":"mnopqrstuvwxyz123456"}}

B编码=d1:rd2:id20:mnopqrstuvwxyz123456e1:t2:aa1:y1:re


find_node

Findnode被用来查找给定ID的node的联系信息。这时KPRC协议中的q=“find_node”。find_node请求包含2个参数，第一个参数是id，包含了请求node的nodeID。第二个参数是target，包含了请求者正在查找的node的nodeID。当一个node接收到了find_node的请求，他应该给出对应的回复，回复中包含2个关键字id和nodes，nodes是一个字符串类型，包含了被请求节点的路由表中最接近目标node的K(8)个最接近的nodes的联系信息。


参数: {"id"&nbsp;: "<querying nodes id>","target"&nbsp;: "<id of target node>"}

回复:{"id"&nbsp;: "<queried nodes id>","nodes"&nbsp;: "<compact node info>"}


报文包例子

find_node请求={"t":"aa", "y":"q","q":"find_node", "a":{"id":"abcdefghij0123456789","target":"mnopqrstuvwxyz123456"}}

B编码=d1:ad2:id20:abcdefghij01234567896:target20:mnopqrstuvwxyz123456e1:q9:find_node1:t2:aa1:y1:qe

回复={"t":"aa", "y":"r", "r":{"id":"0123456789abcdefghij", "nodes":"def456..."}}

B编码=d1:rd2:id20:0123456789abcdefghij5:nodes9:def456...e1:t2:aa1:y1:re


get_peers

Getpeers与torrent文件的info_hash有关。这时KPRC协议中的”q”=”get_peers”。get_peers请求包含2个参数。第一个参数是id，包含了请求node的nodeID。第二个参数是info_hash，它代表torrent文件的infohash。如果被请求的节点有对应info_hash的peers，他将返回一个关键字values,这是一个列表类型的字符串。每一个字符串包含了"CompactIP-address/portinfo"格式的peers信息。如果被请求的节点没有这个infohash的peers，那么他将返回关键字nodes，这个关键字包含了被请求节点的路由表中离info_hash最近的K个nodes，使用"Compactnodeinfo"格式回复。在这两种情况下，关键字token都将被返回。token关键字在今后的annouce_peer请求中必须要携带。Token是一个短的二进制字符串。


参数: {"id"&nbsp;: "<querying nodes id>","info_hash"&nbsp;: "<20-byte infohash of targettorrent>"}

回复:{"id"&nbsp;: "<queried nodes id>","token"&nbsp;:"<opaque write token>","values"&nbsp;: ["<peer 1 info string>","<peer 2 info string>"]}

or:{"id"&nbsp;: "<queried nodes id>","token"&nbsp;:"<opaque write token>","nodes"&nbsp;: "<compact node info>"}



报文包例子

get_peers请求={"t":"aa", "y":"q","q":"get_peers", "a":{"id":"abcdefghij0123456789","info_hash":"mnopqrstuvwxyz123456"}}

B编码=d1:ad2:id20:abcdefghij01234567899:info_hash20:mnopqrstuvwxyz123456e1:q9:get_peers1:t2:aa1:y1:qe

回复peers ={"t":"aa", "y":"r", "r":{"id":"abcdefghij0123456789", "token":"aoeusnth","values": ["axje.u", "idhtnm"]}}

B编码=d1:rd2:id20:abcdefghij01234567895:token8:aoeusnth6:valuesl6:axje.u6:idhtnmee1:t2:aa1:y1:re

回复最接近的nodes= {"t":"aa", "y":"r", "r":{"id":"abcdefghij0123456789", "token":"aoeusnth","nodes": "def456..."}}

B编码=d1:rd2:id20:abcdefghij01234567895:nodes9:def456...5:token8:aoeusnthe1:t2:aa1:y1:re


announce_peer

这个请求用来表明发出announce_peer请求的node，正在某个端口下载torrent文件。announce_peer包含4个参数。第一个参数是id，包含了请求node的nodeID；第二个参数是info_hash，包含了torrent文件的infohash；第三个参数是port包含了整型的端口号，表明peer在哪个端口下载；第四个参数数是token，这是在之前的get_peers请求中收到的回复中包含的。收到announce_peer请求的node必须检查这个token与之前我们回复给这个节点get_peers的token是否相同。如果相同，那么被请求的节点将记录发送announce_peer节点的IP和请求中包含的port端口号在peer联系信息中对应的infohash下。


参数: {"id": "<querying nodes id>", "info_hash" :"<20-byte infohash of target torrent>", "port": <port number>, "token" : "<opaque token>"}

回复: {"id": "<queried nodes id>"}

报文包例子

announce_peers请求={"t":"aa", "y":"q","q":"announce_peer", "a":{"id":"abcdefghij0123456789","info_hash":"mnopqrstuvwxyz123456", "port":6881, "token": "aoeusnth"}}

B编码=d1:ad2:id20:abcdefghij01234567899:info_hash20:<br />

mnopqrstuvwxyz1234564:porti6881e5:token8:aoeusnthe1:q13:announce_peer1:t2:aa1:y1:qe

回复={"t":"aa", "y":"r", "r":{"id":"mnopqrstuvwxyz123456"}}

B编码=d1:rd2:id20:mnopqrstuvwxyz123456e1:t2:aa1:y1:re
 *
 */

public abstract class Req extends Msg_base{
	protected String _from;
	protected String _t;
	protected String _y;
	protected String _q;
	protected String _a;
	
	public Req() {
		this._t = "tt";
		this._y = "q";
		this._q = "";
		this._a ="";
	}
	
	//ping
//	public void action_ping() {
////		String tmp_str = "{"t":"aa", "y":"q","q":"ping", "a":{"id":"abcdefghij0123456789"}}";
//	}
	
	
	//find_node
	
	//get_peers
	
	//announce_peer（对应Kademlia中的store消息）
	
	
	public abstract byte[] toData() ;
}
