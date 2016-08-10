package core.dht.msg.req;

import core.dht.msg.Msg_base;

/**
 * 
 *ping

��������������ping����ʱKPRCЭ���еġ�q��=��ping����Ping�������һ������id������һ��20�ֽڵ��ַ��������˷����������ֽ����nodeID����Ӧ��ping�ظ�Ҳ����һ������id�������˻ظ��ߵ�nodeID��


����: {"id"&nbsp;: "<querying nodes id>"}

�ظ�:{"id"&nbsp;: "<queried nodes id>"}


���İ�����

ping����={"t":"aa", "y":"q","q":"ping", "a":{"id":"abcdefghij0123456789"}}

B����=d1:ad2:id20:abcdefghij0123456789e1:q4:ping1:t2:aa1:y1:qe

�ظ�={"t":"aa", "y":"r", "r":{"id":"mnopqrstuvwxyz123456"}}

B����=d1:rd2:id20:mnopqrstuvwxyz123456e1:t2:aa1:y1:re


find_node

Findnode���������Ҹ���ID��node����ϵ��Ϣ����ʱKPRCЭ���е�q=��find_node����find_node�������2����������һ��������id������������node��nodeID���ڶ���������target�����������������ڲ��ҵ�node��nodeID����һ��node���յ���find_node��������Ӧ�ø�����Ӧ�Ļظ����ظ��а���2���ؼ���id��nodes��nodes��һ���ַ������ͣ������˱�����ڵ��·�ɱ�����ӽ�Ŀ��node��K(8)����ӽ���nodes����ϵ��Ϣ��


����: {"id"&nbsp;: "<querying nodes id>","target"&nbsp;: "<id of target node>"}

�ظ�:{"id"&nbsp;: "<queried nodes id>","nodes"&nbsp;: "<compact node info>"}


���İ�����

find_node����={"t":"aa", "y":"q","q":"find_node", "a":{"id":"abcdefghij0123456789","target":"mnopqrstuvwxyz123456"}}

B����=d1:ad2:id20:abcdefghij01234567896:target20:mnopqrstuvwxyz123456e1:q9:find_node1:t2:aa1:y1:qe

�ظ�={"t":"aa", "y":"r", "r":{"id":"0123456789abcdefghij", "nodes":"def456..."}}

B����=d1:rd2:id20:0123456789abcdefghij5:nodes9:def456...e1:t2:aa1:y1:re


get_peers

Getpeers��torrent�ļ���info_hash�йء���ʱKPRCЭ���еġ�q��=��get_peers����get_peers�������2����������һ��������id������������node��nodeID���ڶ���������info_hash��������torrent�ļ���infohash�����������Ľڵ��ж�Ӧinfo_hash��peers����������һ���ؼ���values,����һ���б����͵��ַ�����ÿһ���ַ���������"CompactIP-address/portinfo"��ʽ��peers��Ϣ�����������Ľڵ�û�����infohash��peers����ô�������عؼ���nodes������ؼ��ְ����˱�����ڵ��·�ɱ�����info_hash�����K��nodes��ʹ��"Compactnodeinfo"��ʽ�ظ���������������£��ؼ���token���������ء�token�ؼ����ڽ���annouce_peer�����б���ҪЯ����Token��һ���̵Ķ������ַ�����


����: {"id"&nbsp;: "<querying nodes id>","info_hash"&nbsp;: "<20-byte infohash of targettorrent>"}

�ظ�:{"id"&nbsp;: "<queried nodes id>","token"&nbsp;:"<opaque write token>","values"&nbsp;: ["<peer 1 info string>","<peer 2 info string>"]}

or:{"id"&nbsp;: "<queried nodes id>","token"&nbsp;:"<opaque write token>","nodes"&nbsp;: "<compact node info>"}



���İ�����

get_peers����={"t":"aa", "y":"q","q":"get_peers", "a":{"id":"abcdefghij0123456789","info_hash":"mnopqrstuvwxyz123456"}}

B����=d1:ad2:id20:abcdefghij01234567899:info_hash20:mnopqrstuvwxyz123456e1:q9:get_peers1:t2:aa1:y1:qe

�ظ�peers ={"t":"aa", "y":"r", "r":{"id":"abcdefghij0123456789", "token":"aoeusnth","values": ["axje.u", "idhtnm"]}}

B����=d1:rd2:id20:abcdefghij01234567895:token8:aoeusnth6:valuesl6:axje.u6:idhtnmee1:t2:aa1:y1:re

�ظ���ӽ���nodes= {"t":"aa", "y":"r", "r":{"id":"abcdefghij0123456789", "token":"aoeusnth","nodes": "def456..."}}

B����=d1:rd2:id20:abcdefghij01234567895:nodes9:def456...5:token8:aoeusnthe1:t2:aa1:y1:re


announce_peer

�������������������announce_peer�����node������ĳ���˿�����torrent�ļ���announce_peer����4����������һ��������id������������node��nodeID���ڶ���������info_hash��������torrent�ļ���infohash��������������port���������͵Ķ˿ںţ�����peer���ĸ��˿����أ����ĸ���������token��������֮ǰ��get_peers�������յ��Ļظ��а����ġ��յ�announce_peer�����node���������token��֮ǰ���ǻظ�������ڵ�get_peers��token�Ƿ���ͬ�������ͬ����ô������Ľڵ㽫��¼����announce_peer�ڵ��IP�������а�����port�˿ں���peer��ϵ��Ϣ�ж�Ӧ��infohash�¡�


����: {"id": "<querying nodes id>", "info_hash" :"<20-byte infohash of target torrent>", "port": <port number>, "token" : "<opaque token>"}

�ظ�: {"id": "<queried nodes id>"}

���İ�����

announce_peers����={"t":"aa", "y":"q","q":"announce_peer", "a":{"id":"abcdefghij0123456789","info_hash":"mnopqrstuvwxyz123456", "port":6881, "token": "aoeusnth"}}

B����=d1:ad2:id20:abcdefghij01234567899:info_hash20:<br />

mnopqrstuvwxyz1234564:porti6881e5:token8:aoeusnthe1:q13:announce_peer1:t2:aa1:y1:qe

�ظ�={"t":"aa", "y":"r", "r":{"id":"mnopqrstuvwxyz123456"}}

B����=d1:rd2:id20:mnopqrstuvwxyz123456e1:t2:aa1:y1:re
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
	
	//announce_peer����ӦKademlia�е�store��Ϣ��
	
	
	public abstract byte[] toData() ;
}
