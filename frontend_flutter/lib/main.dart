import 'package:flutter/material.dart';
import 'package:http/http.dart' as http; // 导入 http 包
import 'dart:convert'; // 导入 dart:convert 以便解析 JSON
import 'package.flutter/foundation.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Spring Boot Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String _backendMessage = 'Press the button to get a message from the backend.';

  Future<void> _fetchHelloWorld() async {
    // 2. 根据平台选择不同的 URL
    // 如果是 Web 平台，使用 localhost
    // 如果是移动平台 (Android/iOS)，使用 10.0.2.2
    final String host = kIsWeb ? 'localhost' : '10.0.2.2';
    final url = Uri.parse('http://$host:8080/api/hello');

    setState(() {
      _backendMessage = 'Connecting to $url ...'; // 添加一个加载提示，提升用户体验
    });

    try {
      final response = await http.get(url);

      if (response.statusCode == 200) {
        final data = json.decode(response.body);
        final message = data['message'];
        setState(() {
          _backendMessage = message;
        });
      } else {
        setState(() {
          _backendMessage = 'Failed to load data. Status code: ${response.statusCode}\nResponse body: ${response.body}';
        });
      }
    } catch (e) {
      setState(() {
        _backendMessage = 'Error connecting to the server: $e';
      });
    }
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Flutter + Spring Boot'),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              const Text(
                'Message from Backend:',
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              const SizedBox(height: 20),
              // 显示从后端获取的消息
              Text(
                _backendMessage,
                style: const TextStyle(fontSize: 16, color: Colors.deepPurple),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 40),
              // 按钮，点击时调用 _fetchHelloWorld 方法
              ElevatedButton(
                onPressed: _fetchHelloWorld,
                child: const Text('Get Message'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}