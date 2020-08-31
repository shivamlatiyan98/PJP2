const express = require('express')
const app = express()
const port = 3000;
const  moment=require('moment');
const dateobj=moment();
var multer = require('multer');
var upload = multer();

var bodyParser = require('body-parser');


app.use(express.static(__dirname + '/public'));

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(upload.array());

app.get('/',(req, res) =>  {
    res.sendFile("index.html");




})


app.get('/getdate',(req, res) =>  {

    res.json({ username: res.json({ day: dateobj.get('day').toString() , curdate:dateobj.get().toString()})
    })




})


app.get('/getday',(req, res) =>  {

    var date1=req.query.date;

    var dobj=new Date(date1);

    var ans=dobj.getDay();

    var a={0:"sunday",1:"monday",2:"tuesday",3:"wednesday",4:"thursday",5:"friday",6:"saturday"};

    res.send({day:a[ans]});







})




app.get('/adddays',(req, res) =>  {

    var days=req.query.days1;
    var date1=req.query.date1;
    var dobj=new Date(date1);
    var a=parseInt(days);
    console.log(dobj);
    dobj.setDate(dobj.getDate() + a);
    console.log(dobj);
    res.send(dobj.toDateString());







})

app.get('/getmonth',(req, res) =>  {


    var date1=req.query.date;
    var dobj=new Date(date1);
    var ans=dobj.getMonth()+1;

    res.send({month:ans})






})

app.get('/nlpquery',(req, res) =>  {



    var dobj=new Date();
    var nlp=req.query.nlp;

    var h = new Object();
    h['today'] = 1;
    h['yesterday'] = -1;
    h['tommorow'] = 1;
    h['day after tommorow']=2;
    h['day before yesterday']=-2;

     dobj.setDate(dobj.getDate()+h[nlp]);

     res.send(dobj.toDateString());








})









app.get('/subtractdate',(req, res) =>  {

    res.json({ username: res.json({ day: dateobj.get('day').toString() , curdate:dateobj.get().toString()})
    })




})

var date1;
var  date2;

app.get('/adddate/',(req, res) =>  {

    console.log("sub");

    //console.log(req);
    date1=req.query.date1;
    date2=req.query.date2;
    console.log(req.params,date1,date2);
    console.log(req.body);
    console.log(req.url);






    console.log(date1);
    console.log(date2);


    dateobj.add()
    var d1=new Date(date1);
    var d2=new Date(date2);

    var ans=new Date(d1+d2);
   console.log(d1,d2);
   console.log(ans);

res.send("added");






})



app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})