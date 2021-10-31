# SkywarsPlugin
1.17 스카이워즈 플러그인입니다. 

설정방법
-

1. 플러그인 파일을 넣는다.
2. plugins 폴더에 skywarsplugin 폴더를 만든다.
3. skywarsplugin 폴더에 drop.json, pvpmap.json, userdata.db를 만든다.
4. 싸우는 맵의 이름을 pvpmap으로 하여 서버 폴더에 넣어준다.

- drop.json: 상자 아이템 확률 조정

형태는 

```
pearl
gapple
blocks
  -plank
(전부 amount, percent 포함)

armor (amount 필요 없음)
  -iron => percent 포함
    -boots
    -leggings
    -chestplate
    -helmet
    (전부 percent 포함)
 ```
    
이다.
percent에는 확률을, amount에는 값을 적으면 된다. pearl, gapple, block은 amount가 필요하고, armor는 amount를 필요로 하지 않는다.



- pvpmap.json: 스폰지점과 상자위치 지정

형태는

```
locations (상자 위치)
  - [
      [x값, y값, z값],
      [x값, y값, z값],
      ...
    ]

spawn (플레이어 스폰 위치, 최대 플레이어 수만큼 있어야 함)
  - [
      [x값, y값, z값],
      [x값, y값, z값],
      ...
    ]

```
이다. 



- userdata.db: 데이터베이스 파일. 

명령어
-

- /refill: 테스트용. 0,5,0에 있는 상자를 리필한다.
- /reset: 테스트용. pvpmap 월드를 리셋한다.
- /queue [join / leave]: 큐에 들어가거나 나간다. 2명 모이면 자동 시작
- /stats: 자신의 스탯을 보여준다.

