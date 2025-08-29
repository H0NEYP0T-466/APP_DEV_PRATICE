import 'package:flutter/material.dart';

void main()
{
  runApp(MyApp());
}

class MyApp extends StatelessWidget
{
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp
      (
      //title: 'MyApp',
      home: MyHomePage(),
      debugShowCheckedModeBanner: false,
    );
  }

}


class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage>  {

  int counter=0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          'Counter App',
          style: TextStyle(
            fontWeight: FontWeight.bold,
            color: Colors.amber,
            fontSize: 25,
          ),
        ),
        centerTitle: true,
      ),
      body:
          Container(
            width: double.infinity,
      child:
      Column(

        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget> [Text('You pressed this button $counter times',style: TextStyle(color: Colors.black,fontSize: 20,fontWeight: FontWeight.bold)),
          ElevatedButton(
            onPressed: () {
              setState(() {
                counter++;
              });

            },
            child: Text('Click Me'),
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.black,
              foregroundColor: Colors.white,
              padding: EdgeInsets.symmetric(horizontal: 24, vertical: 12),
              textStyle: TextStyle(fontSize: 18),
            ),
          )],

      )
          ),

      );

  }
}

