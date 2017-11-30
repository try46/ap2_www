/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package en09;

public class Tweet {

    //フィールド
    private int tweetNo;	//ツイートの番号
    private String twitterID;	//twitterID
    private String name;	//氏名
    private String tweetTime;	//投稿日時
    private String text;	//投稿内容

    //コンストラクタ
    public Tweet() {
        //とりあえず何もしない
    }

    //ツイート番号をセットするメソッド
    public Tweet(int tn, String id, String nm, String tt, String te) {
        this.tweetNo = tn;
        this.twitterID = id;
        this.name = nm;
        this.tweetTime = tt;
        this.text = te;
    }

    @Override
    public String toString() {
        return tweetNo + ":" + twitterID + "(" + name + ")" + "<br>" + tweetTime + "<br>" + text;
    }

}
