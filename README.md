# Android push通知 sample
Androidのpush 通知を勉強するためのサンプルです。

# 実行手順
1. 以下のURLでAPI利用登録を行ってください。（詳しい手順はぐぐると結構情報が出てきます。）  
https://code.google.com/apis/console/  
※登録については、こちらのブログが参考になりました。(http://freestyle.nvo.jp/archives/1218)
2. 登録時に、`Project Number`と`API key`をメモしておいてください。
3. `android-push-sample/PushSample/src/com/sample/pushsample/CommonUtilities.java`を開いて、`Project Number`を入力して下さい。
4. `android-push-sample`をeclipseで開いて、コンパイルし、apkファイルを作成し、実行して下さい。
5. 実行するとEditText部分に`registration ID`が表示されているので、これをコピーして下さい。
6. `push.php`を開いて、`registration ID`と、`API key`を入力して下さい。
7. `php push.php`で実行中のAndroid端末にpush通知がされるはずです。

