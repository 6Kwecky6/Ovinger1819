function update(){
    return fetch("http://bigdata.stud.iie.ntnu.no/sentiment/webresources/sentiment?api-key=Happy!!!",{
        method:"POST",
        headers:{
            'Content-Type':'application/json; charset=utf-8'
        },
        body: JSON.stringify({
            sentence: document.querySelector('#sentence').value
        })
    }).then(response => response.json())
    .then((response)=>{
        console.log(response);
        let res = response.value;
        document.querySelector("#result").innerHTML = res;
        if(1 == res) {
            console.log("Value is 1");
            document.querySelector("BODY").style.backgroundColor="red";
        }else if(res == 2){
            console.log("Valuse is 2");
            document.querySelector("BODY").style.backgroundColor="gray";
        }else if(res == 3){
            console.log("Valuse is 3");
            document.querySelector("BODY").style.backgroundColor="yellow";
        }else if(res == 4){
            console.log("Value is 4");
            document.querySelector("BODY").style.backgroundColor="green";
        }else{
            console.log("Value is empty");
            document.querySelector("BODY").style.backgroundColor="white";
        }
    })
        .catch(error=> console.log("Fetch flop: " + error))
}
