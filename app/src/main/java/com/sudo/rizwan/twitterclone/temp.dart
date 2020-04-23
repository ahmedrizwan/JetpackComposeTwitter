import 'package:flutter/material.dart';

void main() {
  runApp(CustomTheme(child: Twittr()));
}

//INFO: Model User
class User {
  String name;
  String username;
  String avatar;
  String banner;
  String bio;
  int following;
  int followers;
  bool verified;

  User(this.name, this.username, this.avatar, this.banner, this.bio, this.following, this.followers, this.verified);
}

//INFO: Model Twt
class Twt {
  User user;
  String twt;
  String image;
  int likes;
  int retwts;
  int comments;
  int timestamp;
  bool retwted;
  bool liked;

  Twt(this.user, this.twt, this.image, this.likes, this.liked, this.retwts, this.retwted, this.comments,
      this.timestamp);
}

//INFO: Main Screen
class Twittr extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Twittr',
      theme: CustomTheme.of(context),
      home: HomeScreen(),
    );
  }
}

//INFO: Home Screen
class HomeScreen extends StatefulWidget {
  @override
  HomeScreenState createState() => HomeScreenState();
}

class HomeScreenState extends State<HomeScreen> {
  ScrollController _controller;
  CustomThemeState _themeState;

  var _scaffold = GlobalKey<ScaffoldState>();
  var _bottomIndex = 0;
  var _theme = 0;

  //INFO: Users
  static final geekmz = User(
    'Mariano Zorrilla',
    'geekmz',
    'https://avatars2.githubusercontent.com/u/3221810?s=460&u=34b460f73429f22414f7b078ec2edcb40d580aa8&v=4',
    'https://pbs.twimg.com/profile_banners/968284418/1578616922/1500x500',
    'Flutter developer. I create clone apps and much more! 👨‍💻',
    248,
    1480,
    false,
  );
  static final flutterDev = User(
      'Flutter',
      'FlutterDev',
      'https://pbs.twimg.com/profile_images/1187814172307800064/MhnwJbxw_400x400.jpg',
      'https://pbs.twimg.com/profile_banners/420730316/1578350457/1500x500',
      'Google’s UI toolkit to build apps for mobile, web, & desktop from a single codebase //',
      35,
      88675,
      true);

  //INFO: Twts
  final List<Twt> _twts = [
    Twt(
      flutterDev,
      '#FlutterFriday\nis\nhere.\n\nRight pointing backhand indexYou can specify whether your Flutter '
          'project uses Swift, Objective C, Kotlin, or Java by specifying:\n\n"--ios-language objc" or "--android-langu'
          'age java" when you type "flutter create".\n\nElectric light bulbBy default new projects use Kotlin and '
          'Swift.',
      null,
      15,
      false,
      38,
      false,
      244,
      1587345183868,
    ),
    Twt(
      geekmz,
      'This is a test twt to see how all this works, yay!',
      null,
      495,
      false,
      193,
      false,
      2,
      1587343553550,
    ),
    Twt(
      flutterDev,
      '⚡️Flutter is fast by default, but let\'s find out what might affect your app\'s performance.\n\nJoin '
          '@filiphracek at #FlutterEurope as he walks the audience through an app with many performance issues, and '
          'tries to address all of them.\n\nWatch here → https://goo.gle/2UPajJy',
      'https://pbs.twimg.com/media/EUng32oVAAMhOwH?format=jpg&name=medium',
      286,
      false,
      66,
      false,
      5,
      1585852320000,
    ),
    Twt(
      geekmz,
      'Well... this is a more longer twt, I\'m not sure if it works or not but, who knows, maybe it does',
      null,
      198,
      false,
      43,
      false,
      0,
      1585751520000,
    ),
    Twt(
      geekmz,
      'Meh, not much',
      'https://miro.medium.com/max/1400/1*pFq49dtiBDpE5U4tySu-Hg.png',
      34,
      false,
      4,
      false,
      0,
      1585427520000,
    ),
    Twt(
      flutterDev,
      'We are postponing the LATAM Roadshow. The health and safety of our community is our priority. We'
          '\'ll be sure to update you as soon as we have more information.\n\n💙Thank you for keeping this community '
          'thriving, and stay tuned!\n\n- The Flutter Team',
      null,
      150,
      false,
      20,
      false,
      3,
      1585852320000,
    ),
  ];

  void _changeTheme(BuildContext buildContext, ThemeKeys key) {
    if (_themeState == null) {
      _themeState = CustomTheme.instanceOf(buildContext);
      _themeState.changeTheme(key);
    } else {
      _themeState.changeTheme(key);
    }
  }

  @override
  void initState() {
    super.initState();
    _controller = ScrollController();
    Future.delayed(Duration(seconds: 0), () {
      _changeTheme(context, ThemeKeys.LIGHT);
    });
  }

  Future<Null> _refresh() {
    return Future.delayed(Duration(milliseconds: 800), () {
      setState(() {});
    });
  }

  //INFO: Main Build
  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Scaffold(
      key: _scaffold,
      appBar: _appBar(size),
      drawer: _drawer(size),
      bottomNavigationBar: _bottomBar(size),
      backgroundColor: Theme.of(context).primaryColorDark,
      body: RefreshIndicator(
        onRefresh: _refresh,
        child: ListView.builder(
          controller: _controller,
          itemBuilder: (context, index) {
            final twt = _twts[index];
            return _twtWidget(twt);
          },
          itemCount: _twts.length,
        ),
      ),
      floatingActionButton: _fab(),
    );
  }

  //INFO: Twt Item
  Widget _twtWidget(Twt twt) {
    return Column(
      children: [
        Container(
          padding: const EdgeInsets.all(12),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              GestureDetector(
                onTap: () => Navigator.of(context).push(MaterialPageRoute(
                  builder: (context) => ProfileScreen(
                    user: twt.user,
                    list: _twts,
                    context: context,
                    themeState: _themeState,
                  ),
                )),
                child: Container(
                  width: 50,
                  height: 50,
                  decoration: BoxDecoration(borderRadius: BorderRadius.circular(25)),
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(25),
                    child: Image.network(twt.user.avatar, fit: BoxFit.cover),
                  ),
                ),
              ),
              SizedBox(width: 12),
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Row(
                      mainAxisSize: MainAxisSize.min,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Text(twt.user.name, style: TextStyle(fontWeight: FontWeight.w600)),
                        Visibility(
                          visible: twt.user.verified,
                          child: Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              SizedBox(width: 4),
                              if (_themeState != null)
                                Image.network(
                                  'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                                      '.com/o/twtr%2F${_themeState.isDart ? 'verified_white' : 'verified_blue'}'
                                      '.png?alt=media',
                                  width: 15,
                                )
                            ],
                          ),
                        ),
                        SizedBox(width: 5),
                        Opacity(opacity: 0.6, child: Text('@${twt.user.username}')),
                        SizedBox(width: 5),
                        Padding(
                          padding: const EdgeInsets.only(bottom: 8),
                          child: Opacity(opacity: 0.6, child: Text('.')),
                        ),
                        SizedBox(width: 5),
                        Opacity(opacity: 0.6, child: Text(timeAgo(twt.timestamp))),
                      ],
                    ),
                    SizedBox(height: 4),
                    Text(twt.twt),
                    if (twt.image != null)
                      Column(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          SizedBox(height: 8),
                          ClipRRect(
                            borderRadius: BorderRadius.circular(10),
                            child: Image.network(twt.image, fit: BoxFit.fitWidth),
                          ),
                        ],
                      ),
                    SizedBox(height: 12),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Row(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            Image.network(
                              'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                                  '.com/o/twtr%2Fcomment.png?alt=media',
                              width: 15,
                            ),
                            SizedBox(width: 8),
                            Text('${twt.comments}')
                          ],
                        ),
                        InkResponse(
                          onTap: twt.retwted
                              ? () {
                            setState(() {
                              twt.retwts = twt.retwts - 1;
                              twt.retwted = false;
                            });
                          }
                              : () {
                            setState(() {
                              twt.retwts = twt.retwts + 1;
                              twt.retwted = true;
                            });
                          },
                          child: Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Image.network(
                                'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                                    '.com/o/twtr%2F${twt.retwted ? 'retwt_selected' : 'retwt'}.png?alt=media',
                                width: 15,
                              ),
                              SizedBox(width: 8),
                              Text('${twt.retwts}')
                            ],
                          ),
                        ),
                        InkResponse(
                          onTap: twt.liked
                              ? () {
                            setState(() {
                              twt.likes = twt.likes - 1;
                              twt.liked = false;
                            });
                          }
                              : () {
                            setState(() {
                              twt.likes = twt.likes + 1;
                              twt.liked = true;
                            });
                          },
                          child: Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Image.network(
                                'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                                    '.com/o/twtr%2F${twt.liked ? 'liked' : 'like'}.png?alt=media',
                                width: 15,
                              ),
                              SizedBox(width: 8),
                              Text('${twt.likes}')
                            ],
                          ),
                        ),
                        Image.network(
                          'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                              '.com/o/twtr%2Fshare.png?alt=media',
                          width: 15,
                        ),
                        SizedBox()
                      ],
                    )
                  ],
                ),
              )
            ],
          ),
        ),
        Container(height: 1, color: Theme.of(context).selectedRowColor),
      ],
    );
  }

  Widget _drawer(Size size) {
    return Container(
      width: 280,
      height: size.height,
      color: Theme.of(context).primaryColorDark,
      child: Column(
        children: [
          Expanded(
            child: SingleChildScrollView(
              child: Column(
                mainAxisSize: MainAxisSize.max,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  GestureDetector(
                    onTap: () {
                      Navigator.of(context).pop();
                      Navigator.of(context).push(MaterialPageRoute(
                        builder: (context) =>
                            ProfileScreen(user: geekmz, list: _twts, context: context, themeState: _themeState),
                      ));
                    },
                    child: Container(
                      width: 60,
                      height: 60,
                      margin: const EdgeInsets.only(top: 15, left: 20),
                      decoration: BoxDecoration(borderRadius: BorderRadius.circular(30)),
                      child: ClipRRect(
                        borderRadius: BorderRadius.circular(30),
                        child: Image.network(geekmz.avatar, fit: BoxFit.cover),
                      ),
                    ),
                  ),
                  SizedBox(height: 10),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Text(geekmz.name, style: TextStyle(fontWeight: FontWeight.w600, fontSize: 16)),
                  ),
                  SizedBox(height: 4),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Opacity(
                      opacity: 0.6,
                      child: Text('@${geekmz.username}'),
                    ),
                  ),
                  SizedBox(height: 14),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text('${geekmz.following}', style: TextStyle(fontWeight: FontWeight.w600)),
                        SizedBox(width: 2),
                        Opacity(opacity: 0.6, child: Text('Following')),
                        SizedBox(width: 15),
                        Text('${geekmz.followers}', style: TextStyle(fontWeight: FontWeight.w600)),
                        SizedBox(width: 2),
                        Opacity(opacity: 0.6, child: Text('Followers')),
                      ],
                    ),
                  ),
                  SizedBox(height: 24),
                  Container(height: 1, color: Theme.of(context).selectedRowColor),
                  SizedBox(height: 24),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Image.network(
                            'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Flists.png?alt=media',
                            width: 25),
                        SizedBox(width: 14),
                        Text('Lists', style: TextStyle(fontSize: 18)),
                      ],
                    ),
                  ),
                  SizedBox(height: 25),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Image.network(
                            'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Ftopics.png?alt=media',
                            width: 25),
                        SizedBox(width: 14),
                        Text('Topics', style: TextStyle(fontSize: 18)),
                      ],
                    ),
                  ),
                  SizedBox(height: 25),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Image.network(
                            'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fbookmarks.png?alt=media',
                            width: 25),
                        SizedBox(width: 14),
                        Text('Bookmarks', style: TextStyle(fontSize: 18)),
                      ],
                    ),
                  ),
                  SizedBox(height: 25),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Image.network(
                            'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fmoments.png?alt=media',
                            width: 25),
                        SizedBox(width: 14),
                        Text('Moments', style: TextStyle(fontSize: 18)),
                      ],
                    ),
                  ),
                  SizedBox(height: 24),
                  Container(height: 1, color: Theme.of(context).selectedRowColor),
                  SizedBox(height: 24),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Text('Settings and privacy', style: TextStyle(fontSize: 18)),
                  ),
                  SizedBox(height: 16),
                  Padding(
                    padding: const EdgeInsets.symmetric(horizontal: 20),
                    child: Text('Help Center', style: TextStyle(fontSize: 18)),
                  ),
                  SizedBox(height: 24),
                ],
              ),
            ),
          ),
          Container(height: 1, color: Theme.of(context).selectedRowColor),
          Container(
            height: 40,
            child: Row(
              mainAxisSize: MainAxisSize.max,
              children: [
                SizedBox(width: 15),
                GestureDetector(
                  onTap: () {
                    Navigator.of(context).pop();
                    _showThemes();
                  },
                  child: Image.network(
                      'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Ftheme.png?alt=media',
                      width: 22),
                ),
                Expanded(
                  child: Align(
                    alignment: Alignment.centerRight,
                    child: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fqrcode.png?alt=media',
                        width: 22),
                  ),
                ),
                SizedBox(width: 15),
              ],
            ),
          )
        ],
      ),
    );
  }

  Widget _fab() {
    return FloatingActionButton(
      foregroundColor: Theme.of(context).accentColor,
      backgroundColor: Theme.of(context).accentColor,
      onPressed: () async {
        var twt = await Navigator.of(context).push(MaterialPageRoute(
          builder: (context) => ComposeTwt(context: context, user: geekmz),
          fullscreenDialog: true,
        ));
        if (twt != null) {
          setState(() => _twts.insert(0, twt));
        }
      },
      child: Padding(
        padding: const EdgeInsets.all(17),
        child: Image.network(
          'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fcompose.png?alt=media',
          width: 30,
        ),
      ),
    );
  }

  Widget _bottomBar(Size size) {
    return Container(
      height: 56,
      child: Column(
        children: [
          Container(
            height: 1,
            width: size.width,
            color: Theme.of(context).selectedRowColor,
          ),
          Expanded(
            child: Theme(
              data: Theme.of(context).copyWith(canvasColor: Theme.of(context).primaryColorDark),
              child: BottomNavigationBar(
                items: [
                  BottomNavigationBarItem(
                      icon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fhome.png?alt=media',
                        width: 24,
                      ),
                      activeIcon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fhome_selected.png?alt=media',
                        width: 24,
                      ),
                      title: Text('')),
                  BottomNavigationBarItem(
                      icon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fsearch.png?alt=media',
                        width: 24,
                      ),
                      activeIcon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fsearch_selected'
                            '.png?alt=media',
                        width: 24,
                      ),
                      title: Text('')),
                  BottomNavigationBarItem(
                      icon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fnotif.png?alt=media',
                        width: 24,
                      ),
                      activeIcon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fnotif_selected'
                            '.png?alt=media',
                        width: 24,
                      ),
                      title: Text('')),
                  BottomNavigationBarItem(
                      icon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fdm.png?alt=media',
                        width: 24,
                      ),
                      activeIcon: Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fdm_selected'
                            '.png?alt=media',
                        width: 24,
                      ),
                      title: Text('')),
                ],
                elevation: 0,
                currentIndex: _bottomIndex,
                onTap: (index) => setState(() => _bottomIndex = index),
                showSelectedLabels: false,
                showUnselectedLabels: false,
                backgroundColor: Colors.white,
              ),
            ),
          ),
        ],
      ),
    );
  }

  Widget _appBar(Size size) {
    return PreferredSize(
      preferredSize: Size(size.width, 50),
      child: Column(
        children: [
          Row(
            children: [
              GestureDetector(
                onTap: () => _scaffold.currentState.isDrawerOpen
                    ? _scaffold.currentState.openEndDrawer()
                    : _scaffold.currentState.openDrawer(),
                child: Container(
                  width: 50,
                  height: 49,
                  child: Center(
                    child: Container(
                      width: 30,
                      height: 30,
                      child: ClipRRect(
                        borderRadius: BorderRadius.circular(15),
                        child: Image.network(geekmz.avatar, fit: BoxFit.cover),
                      ),
                    ),
                  ),
                ),
              ),
              Expanded(
                child: Center(
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      GestureDetector(
                        onTap: () =>
                            _controller.animateTo(0, duration: Duration(milliseconds: 200), curve: Curves.decelerate),
                        child: Image.network(
                          'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Ftwt_icon.png?alt=media',
                          width: 25,
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              Container(
                width: 50,
                height: 49,
                child: Center(
                  child: Column(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Image.network(
                        'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Ftrends.png?alt=media',
                        width: 25,
                      )
                    ],
                  ),
                ),
              ),
            ],
          ),
          Container(
            height: 1,
            width: size.width,
            color: Theme.of(context).selectedRowColor,
          )
        ],
      ),
    );
  }

  void _showThemes() {
    showModalBottomSheet(
      context: context,
      builder: (context) {
        return SingleChildScrollView(
          child: Container(
            color: Colors.transparent,
            child: Container(
              decoration: BoxDecoration(
                color: Theme.of(context).primaryColorDark,
                borderRadius: BorderRadius.only(topLeft: Radius.circular(15), topRight: Radius.circular(15)),
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  SizedBox(height: 10),
                  Container(
                    height: 5,
                    width: 40,
                    decoration: BoxDecoration(
                      color: Colors.grey,
                      borderRadius: BorderRadius.circular(2.5),
                    ),
                  ),
                  SizedBox(height: 10),
                  Text('Dark Mode', style: TextStyle(fontWeight: FontWeight.w600, fontSize: 16)),
                  SizedBox(height: 10),
                  Container(height: 1, color: Theme.of(context).selectedRowColor),
                  SizedBox(height: 10),
                  Row(
                    children: [
                      SizedBox(width: 20),
                      Text('Light', style: TextStyle(fontSize: 16)),
                      Expanded(
                        child: Align(
                          alignment: Alignment.centerRight,
                          child: Radio(
                            value: 0,
                            groupValue: _theme,
                            onChanged: (index) {
                              setState(() => _theme = index);
                              _changeTheme(context, ThemeKeys.LIGHT);
                            },
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(height: 10),
                  Container(height: 1, color: Theme.of(context).selectedRowColor),
                  SizedBox(height: 10),
                  Row(
                    children: [
                      SizedBox(width: 20),
                      Text('Dark', style: TextStyle(fontSize: 16)),
                      Expanded(
                        child: Align(
                          alignment: Alignment.centerRight,
                          child: Radio(
                            value: 1,
                            groupValue: _theme,
                            onChanged: (index) {
                              setState(() => _theme = index);
                              _changeTheme(context, ThemeKeys.DARK);
                            },
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(height: 10),
                  Container(height: 1, color: Theme.of(context).selectedRowColor),
                  SizedBox(height: 10),
                  Row(
                    children: [
                      SizedBox(width: 20),
                      Text('Darker', style: TextStyle(fontSize: 16)),
                      Expanded(
                        child: Align(
                          alignment: Alignment.centerRight,
                          child: Radio(
                            value: 2,
                            groupValue: _theme,
                            onChanged: (index) {
                              setState(() => _theme = index);
                              _changeTheme(context, ThemeKeys.DARKER);
                            },
                          ),
                        ),
                      ),
                    ],
                  ),
                  SizedBox(height: 10),
                  Container(height: 1, color: Theme.of(context).selectedRowColor),
                  SizedBox(height: 10),
                ],
              ),
            ),
          ),
        );
      },
      backgroundColor: Colors.transparent,
    );
  }

  static String timeAgo(int timestamp) {
    final currentTime = DateTime.now().millisecondsSinceEpoch;
    final timeDiff = currentTime - timestamp;
    if (timeDiff >= (1000 * 60 * 60 * 24)) {
      // Days
      return '${timeDiff ~/ (1000 * 60 * 60 * 24)}d';
    } else if (timeDiff >= (1000 * 60 * 60)) {
      // Hours
      return '${timeDiff ~/ (1000 * 60 * 60)}h';
    } else if (timeDiff >= (1000 * 60)) {
      // Minutes
      return '${timeDiff ~/ (1000 * 60)}m';
    } else if (timeDiff >= 1000) {
      // Seconds
      return '${timeDiff ~/ 1000}s';
    }
    return '0s';
  }
}

//INFO: Compose Screen
class ComposeTwt extends StatefulWidget {
  final context;
  final user;

  const ComposeTwt({Key key, this.context, this.user}) : super(key: key);

  @override
  _ComposeTwtState createState() => _ComposeTwtState();
}

class _ComposeTwtState extends State<ComposeTwt> {
  TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Material(
      color: Theme.of(widget.context).primaryColorDark,
      child: Column(
        mainAxisSize: MainAxisSize.max,
        children: [
          Container(
            height: 50,
            padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 10),
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                InkResponse(child: Icon(Icons.close, color: Colors.blue), onTap: () => Navigator.of(context).pop()),
                Expanded(child: SizedBox()),
                RaisedButton(
                  elevation: 0,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(14),
                  ),
                  onPressed: _controller.text.isNotEmpty
                      ? () {
                    Navigator.of(context).pop(Twt(
                      widget.user,
                      _controller.text,
                      null,
                      0,
                      false,
                      0,
                      false,
                      0,
                      DateTime.now().millisecondsSinceEpoch,
                    ));
                  }
                      : null,
                  child: Text('Tweet', style: TextStyle(fontWeight: FontWeight.w600, color: Colors.white)),
                  color: Colors.blue,
                )
              ],
            ),
          ),
          Expanded(
            child: Container(
              padding: const EdgeInsets.all(12),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Container(
                    width: 36,
                    height: 36,
                    decoration: BoxDecoration(borderRadius: BorderRadius.circular(18)),
                    child: ClipRRect(
                      borderRadius: BorderRadius.circular(25),
                      child: Image.network(widget.user.avatar, fit: BoxFit.cover),
                    ),
                  ),
                  SizedBox(width: 12),
                  Expanded(
                    child: TextField(
                      maxLines: 10,
                      maxLength: 240,
                      controller: _controller,
                      style: TextStyle(fontSize: 16),
                      decoration: InputDecoration(
                        hintText: 'What\'s happening?',
                        hintStyle: TextStyle(fontSize: 16, color: Colors.grey),
                        border: InputBorder.none,
                        contentPadding: const EdgeInsets.only(left: 0, right: 0, bottom: 0, top: 8),
                        counterText: '',
                        counterStyle: TextStyle(fontSize: 0),
                      ),
                      onChanged: (text) {
                        setState(() {});
                      },
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}

// INFO: Profile Screen
class ProfileScreen extends StatefulWidget {
  final User user;
  final List<Twt> list;
  final BuildContext context;
  final CustomThemeState themeState;

  const ProfileScreen({Key key, this.user, this.list, this.context, this.themeState}) : super(key: key);

  @override
  _ProfileScreenState createState() => _ProfileScreenState();
}

class _ProfileScreenState extends State<ProfileScreen> {
  final _controller = ScrollController();
  final Color _color = Colors.blue;
  var _opacity = 0.0;
  var _threshold = 85.0;

  void _animateAppBar() {
    _controller.addListener(() {
      if (_controller.offset <= 85) {
        var percentage = (((_threshold - _controller.offset) / 100) - 1).abs();
        if (percentage >= 0 || percentage <= 100) {
          setState(() => _opacity = percentage < 0.2 ? 0 : percentage > 0.9 ? 1 : percentage);
        }
      } else {
        setState(() => _opacity = 1);
      }
    });
  }

  @override
  void initState() {
    super.initState();
    _animateAppBar();
  }

  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Material(
      color: Theme.of(widget.context).primaryColorDark,
      child: Stack(
        children: [
          ListView(
              controller: _controller,
              children: [
                Container(
                  child: Stack(
                    children: [
                      Column(children: [
                        Container(
                          height: 150,
                          width: size.width,
                          child: Image.network(widget.user.banner, fit: BoxFit.cover),
                        ),
                        Container(
                          padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
                          color: Theme.of(widget.context).primaryColorDark,
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Row(
                                mainAxisSize: MainAxisSize.max,
                                mainAxisAlignment: MainAxisAlignment.end,
                                children: [
                                  RaisedButton(
                                    elevation: 0,
                                    shape: RoundedRectangleBorder(
                                        borderRadius: BorderRadius.circular(30),
                                        side: BorderSide(color: Colors.blue, width: 2)),
                                    onPressed: () {},
                                    child: Text('Follow',
                                        style: TextStyle(fontWeight: FontWeight.w600, color: Colors.blue)),
                                    color: Colors.transparent,
                                  ),
                                ],
                              ),
                              Text(widget.user.name, style: TextStyle(fontSize: 18, fontWeight: FontWeight.w600)),
                              SizedBox(height: 4),
                              Opacity(
                                opacity: 0.6,
                                child: Text('@${widget.user.username}', style: TextStyle(fontSize: 15)),
                              ),
                              SizedBox(height: 8),
                              Text(widget.user.bio, style: TextStyle(fontSize: 15)),
                              SizedBox(height: 8),
                              Row(
                                mainAxisSize: MainAxisSize.min,
                                children: [
                                  Text('${widget.user.following}', style: TextStyle(fontWeight: FontWeight.w600)),
                                  SizedBox(width: 2),
                                  Opacity(opacity: 0.6, child: Text('Following')),
                                  SizedBox(width: 15),
                                  Text('${widget.user.followers}', style: TextStyle(fontWeight: FontWeight.w600)),
                                  SizedBox(width: 2),
                                  Opacity(opacity: 0.6, child: Text('Followers')),
                                ],
                              ),
                            ],
                          ),
                        ),
                        SizedBox(height: 10),
                        Container(height: 1, color: Theme.of(context).selectedRowColor),
                        SizedBox(height: 10),
                      ]),
                      Padding(
                        padding: const EdgeInsets.only(left: 15, top: 100),
                        child: Container(
                          width: 100,
                          height: 100,
                          alignment: Alignment.center,
                          padding: const EdgeInsets.all(4),
                          decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(50),
                              color: Theme.of(widget.context).primaryColorDark),
                          child: ClipRRect(
                            borderRadius: BorderRadius.circular(50),
                            child: Image.network(widget.user.avatar, fit: BoxFit.cover),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ]
                  .followedBy(widget.list
                  .where((item) => item.user.username == widget.user.username)
                  .toList()
                  .map((twt) => _twtWidget(twt)))
                  .toList()),
          PreferredSize(
            preferredSize: Size(size.width, 50),
            child: Container(
              height: 60,
              color: _color.withOpacity(_opacity),
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 15, vertical: 10),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    InkResponse(
                      onTap: () => Navigator.of(context).pop(),
                      child: Container(
                        width: 40,
                        height: 40,
                        decoration: BoxDecoration(borderRadius: BorderRadius.circular(20), color: Colors.black12),
                        child: Center(
                          child: Icon(Icons.arrow_back, color: Colors.white),
                        ),
                      ),
                    ),
                    Expanded(child: Container()),
                    Column(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Container(
                          width: 40,
                          height: 40,
                          decoration: BoxDecoration(borderRadius: BorderRadius.circular(20), color: Colors.black12),
                          child: Center(
                            child: Icon(Icons.more_vert, color: Colors.white),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }

  //INFO: Profile Twt Item
  Widget _twtWidget(Twt twt) {
    return Container(
      child: Column(
        children: [
          Container(
            padding: const EdgeInsets.all(12),
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                  width: 50,
                  height: 50,
                  decoration: BoxDecoration(borderRadius: BorderRadius.circular(25)),
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(25),
                    child: Image.network(twt.user.avatar, fit: BoxFit.cover),
                  ),
                ),
                SizedBox(width: 12),
                Expanded(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Row(
                        mainAxisSize: MainAxisSize.min,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          Text(twt.user.name, style: TextStyle(fontWeight: FontWeight.w600)),
                          Visibility(
                            visible: twt.user.verified,
                            child: Row(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                SizedBox(width: 4),
                                if (widget.themeState != null)
                                  Image.network(
                                    'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                                        '.com/o/twtr%2F${widget.themeState.isDart ? 'verified_white' : 'verified_blue'}'
                                        '.png?alt=media',
                                    width: 15,
                                  )
                              ],
                            ),
                          ),
                          SizedBox(width: 5),
                          Opacity(opacity: 0.6, child: Text('@${twt.user.username}')),
                          SizedBox(width: 5),
                          Padding(
                            padding: const EdgeInsets.only(bottom: 8),
                            child: Opacity(opacity: 0.6, child: Text('.')),
                          ),
                          SizedBox(width: 5),
                          Opacity(opacity: 0.6, child: Text(HomeScreenState.timeAgo(twt.timestamp))),
                        ],
                      ),
                      SizedBox(height: 4),
                      Text(twt.twt),
                      if (twt.image != null)
                        Column(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            SizedBox(height: 8),
                            ClipRRect(
                              borderRadius: BorderRadius.circular(10),
                              child: Image.network(twt.image, fit: BoxFit.fitWidth),
                            ),
                          ],
                        ),
                      SizedBox(height: 12),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Image.network(
                                'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot'
                                    '.com/o/twtr%2Fcomment.png?alt=media',
                                width: 15,
                              ),
                              SizedBox(width: 8),
                              Text('${twt.comments}')
                            ],
                          ),
                          InkResponse(
                            onTap: twt.retwted
                                ? () {
                              setState(() {
                                twt.retwts = twt.retwts - 1;
                                twt.retwted = false;
                              });
                            }
                                : () {
                              setState(() {
                                twt.retwts = twt.retwts + 1;
                                twt.retwted = true;
                              });
                            },
                            child: Row(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                Image.network(
                                  'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2F${twt.retwted ? 'retwt_selected' : 'retwt'}.png?alt=media',
                                  width: 15,
                                ),
                                SizedBox(width: 8),
                                Text('${twt.retwts}')
                              ],
                            ),
                          ),
                          InkResponse(
                            onTap: twt.liked
                                ? () {
                              setState(() {
                                twt.likes = twt.likes - 1;
                                twt.liked = false;
                              });
                            }
                                : () {
                              setState(() {
                                twt.likes = twt.likes + 1;
                                twt.liked = true;
                              });
                            },
                            child: Row(
                              mainAxisSize: MainAxisSize.min,
                              children: [
                                Image.network(
                                  'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2F${twt.liked ? 'liked' : 'like'}.png?alt=media',
                                  width: 15,
                                ),
                                SizedBox(width: 8),
                                Text('${twt.likes}')
                              ],
                            ),
                          ),
                          Image.network(
                            'https://firebasestorage.googleapis.com/v0/b/flutter-yeti.appspot.com/o/twtr%2Fshare.png?alt=media',
                            width: 15,
                          ),
                          SizedBox()
                        ],
                      )
                    ],
                  ),
                )
              ],
            ),
          ),
          Container(height: 1, color: Theme.of(context).selectedRowColor),
        ],
      ),
    );
  }
}

//INFO: Themes
enum ThemeKeys { LIGHT, DARK, DARKER }

class Themes {
  static final ThemeData lightTheme = ThemeData(
    primaryColor: Colors.blue,
    accentColor: Colors.blue,
    brightness: Brightness.light,
    textTheme: TextTheme(headline6: TextStyle(color: Colors.grey[850]), subtitle1: TextStyle(color: Colors.grey[850])),
    primaryColorLight: Colors.grey[700],
    primaryColorDark: Colors.white,
    selectedRowColor: Colors.grey[300],
  );

  static final ThemeData darkTheme = ThemeData(
    primaryColor: Colors.grey,
    accentColor: Colors.blue,
    brightness: Brightness.dark,
    textTheme: TextTheme(headline6: TextStyle(color: Colors.white), subtitle1: TextStyle(color: Colors.white)),
    primaryColorLight: Colors.grey[400],
    primaryColorDark: Colors.grey[850],
    selectedRowColor: Colors.grey[700],
  );

  static final ThemeData darkerTheme = ThemeData(
    primaryColor: Colors.black,
    accentColor: Colors.blue,
    brightness: Brightness.dark,
    textTheme: TextTheme(headline6: TextStyle(color: Colors.white), subtitle1: TextStyle(color: Colors.white)),
    primaryColorLight: Colors.grey[400],
    primaryColorDark: Colors.black,
    selectedRowColor: Colors.grey[850],
  );

  static ThemeData getThemeFromKey(ThemeKeys themeKey) {
    switch (themeKey) {
      case ThemeKeys.LIGHT:
        return lightTheme;
      case ThemeKeys.DARK:
        return darkTheme;
      case ThemeKeys.DARKER:
        return darkerTheme;
      default:
        return lightTheme;
    }
  }
}

class CustomTheme extends StatefulWidget {
  final Widget child;
  final ThemeKeys initialThemeKey;

  const CustomTheme({Key key, this.initialThemeKey, @required this.child}) : super(key: key);

  @override
  CustomThemeState createState() => CustomThemeState();

  static ThemeData of(BuildContext context) {
    _CustomTheme inherited = (context.dependOnInheritedWidgetOfExactType<_CustomTheme>());
    return inherited.data.theme;
  }

  static CustomThemeState instanceOf(BuildContext context) {
    _CustomTheme inherited = (context.dependOnInheritedWidgetOfExactType<_CustomTheme>());
    return inherited.data;
  }
}

class CustomThemeState extends State<CustomTheme> {
  ThemeData _theme;

  ThemeData get theme => _theme;

  ThemeKeys _themeKey;

  ThemeKeys get themeKey => _themeKey;

  bool get isDart => _themeKey == ThemeKeys.DARK || _themeKey == ThemeKeys.DARKER;

  @override
  void initState() {
    _theme = Themes.getThemeFromKey(widget.initialThemeKey);
    _themeKey = widget.initialThemeKey;
    super.initState();
  }

  void changeTheme(ThemeKeys themeKey) {
    setState(() {
      _theme = Themes.getThemeFromKey(themeKey);
      _themeKey = themeKey;
    });
  }

  @override
  Widget build(BuildContext context) {
    return new _CustomTheme(
      data: this,
      child: widget.child,
    );
  }
}

class _CustomTheme extends InheritedWidget {
  final CustomThemeState data;

  _CustomTheme({this.data, Key key, @required Widget child}) : super(key: key, child: child);

  @override
  bool updateShouldNotify(_CustomTheme oldWidget) {
    return true;
  }
}

