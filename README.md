# タスク管理アプリケーション(CLI)
https://github.com/Shusei9595/task-cil (from：[https://roadmap.sh/projects/task-tracker])

コマンドラインインターフェース(CLI)のタスク管理アプリケーションです。
以下のコマンドを実行できます。

- add

タスクを追加することができます。引数にはタスクの説明を記載します。
追加したタスクにはIDが自動的に割り振られます。

    例：add 買い物

- update

タスクの説明を更新することが出来ます。引数にはタスクのIDと更新後の説明を記載します。

    例：update 1 買い物と料理

- delete

タスクを削除することが出来ます。引数にはタスクのIDを記載します。

    例：delete 1

- list

タスクの一覧を確認することができます。
引数に以下を指定することで指定したステータスのタスクのみを確認することができます。

    引数： todo in-progress done

引数を指定しない場合はすべてのタスクを確認することができます。

    例：list

    例：list todo

- mark-in-progress
- mark-in-done

タスクのステータスを変更することができます。
引数に指定したタスクIDのステータスが変更されます。

    例：mark-in-progress 2
    例：mark-in-done 3

