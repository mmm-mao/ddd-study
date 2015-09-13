## [2015/07/17]仕様変更
新しく以下の仕様を追加します。  

[変更要件]
* 会員登録時のクレジットカードが無効になった場合にサービス利用不可とする。  
* 利用不可は即時で反映される。
* 無効になったクレジットカードの情報はクレジットカード会社から連携される。  
* クレジットカードを有効にするには、会員自身が書面でIDと有効なクレジットカード情報を会員事務局へ郵送する。  
* 有効なクレジットカード情報を受け取った会員事務局がクレジットカード情報を有効にする。  
* クレジットカードが有効になった場合は、即時にサービス利用可能とする。  
* クレジットカード情報を会員がWebから変更できるようにする。  

>7/28補足  
・一度無効になったクレジットカードも、会員自身がカード会社と手続きする事で  
　【同一カード番号】【延長された有効期限】での有効化が世の中的にあると考え。  
　有効⇄無効の状態の行き来は　【有り】　と考えてください。  

>例）一般的にクレジットカードは、有効期限が切れる1ヶ月前に  
　有効期限、セキュリティコードが更新された新しいカード送られてきます。  
　その後ビッグローブのクレジットカード情報を更新します。  
　ビッグローブのクレジットカード情報変更前に、  
　変更前のクレジットカードの有効期限が切れてしまうこともありえます。  
　その場合は、同一クレジットカード番号で、新しい有効期限、セキュリティコードを  
　書面で郵送すれば、同一のクレジットカード番号を再度利用することができます。  

>・上記の前提ですので、書面で有効なクレジットカード情報を送る際は  
　【同一カード番号】【延長された有効期限】のパタンも有ります。  


## [2015/06/26]仕様変更
BIGLOBEがニコニコ動画と提携することになりました。  
既存の「ベーシック」コースの他に「ニコニコ」コースが追加になり、  
このコースに所属しているとBIGLOBE ID/BIGLOBEパスワードでニコニコ動画にログインできるようにします。  
また、それに伴い、コース変更機能とニコニコ動画向けのBIGLOBE認証機能の追加が必要になります。

# サービス仕様
## WebからのBIGLOBE新規入会

* BIGLOBE非会員が入会ページより入会を申し込む。
* 入会可能条件を満たした場合、BIGLOBEに入会することができる。

### 前提条件

1. 入会可能条件は次の通り。
   1. 同一と思われる人物が既に入会済みでない  
      ~~※氏名および氏名かなが合致するかで判定するものとする。~~   
     **★[2015/07/16]仕様変更 同一クレジットカード情報での登録不可とする。**
  1. 20歳以上である。
  1. 利用可能なクレジットカードを保有している。  
      　※クレジットカードチェック部品は事前にあるものとします。あとでこちらから提示します。

1. 接続コースは「ベーシック」または「ニコニコ」で申し込むこととする。　★[2015/06/26]仕様変更（「ニコニコ」コース追加）
1. ベーシックで申し込むとメールが使えるようになるが、ひとまず今回はそれは考えない。
1. 入会の際、会員登録情報としては申込者の個人情報等を必要とする。  
  その項目は以下を想定する。ただしフォーマットは任意とする。
  * 氏名
  * 氏名かな
  * 性別
  * 生年月日
  * 郵便番号
  * 住所
  * 電話番号
  * 昼間連絡先
  * 希望するBiglobeメアド
  * クレジットカード番号
  * クレジットカード有効期限
  * クレジットカードセキュリティコード

1. BIGLOBE会員登録時にはBIGLOBE IDとBIGLOBEパスワードを払い出す。  
    払い出すための部品は事前にあるものとする。あとで提示します。


## Webからのコース変更申込　★[2015/06/26]機能追加

* BIGLOBE会員がコース変更ページから変更を申し込む。
* コース変更可能条件を満たした場合、コース変更申込日の翌月からコースを切り替えることができる。

### 前提条件
* コース変更可能条件は次の通り。  
　- コース変更申込者が本人であること（退会と同様の認証を想定）  
　- BIGLOBEに入会中であること（退会予約中は入会中とみなす）  
　- 既にコース変更を申し込んでいないこと  
　- 変更を申し込むコースが適用中のコースとは異なること
* コースは下記の２つとなる  
　-「ベーシック」コース  
　-「ニコニコ」コース
* コース変更のキャンセルは不可とする


## ニコニコ動画向けBIGLOBE認証機能　★[2015/06/26]機能追加

* ニコニコ動画側のシステムから呼び出される
* BIGLOBE IDとBIGLOBEパスワードを入力パラメータとして受け取る
* 現コースが「ベーシック」なら認証NG、「ニコニコ」なら認証OKを返却する
* 退会済みの場合は登録されていないのと同じ扱いとする（認証NGではなく「居ない」）


## WebからのBIGLOBE退会

* BIGLOBE会員が退会ページから退会を申し込む。
* 退会前には自身の会員情報を表示し、本当に退会しても良いかの意思を確認する。　★[2015/06/26]仕様変更（現コースも表示する）
* 退会可能条件を満たした場合、退会申込日の月末をもってBIGLOBEを退会することができる。

### 前提条件

1. 退会可能条件は次の通り。  
  1. 退会申込者が本人であること（BIGLOBE IDとBIGLOBEパスワードによる本人認証を想定）  

  1. 既に退会を申し込んでいないこと。