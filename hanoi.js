const hanoi = (dish)=> {
    var towers = [[],[],[]]
    for(let i = dish ;i>=1 ;i--){
        towers[0].push(i);
    }
    const view = (move)=>{
        console.log("Move "+move);
        for(let i = dish-1 ;i>=0;i--){
            let v = ""
            v+= towers[0][i]?towers[0][i]:' ';
            v+= " | "
            v+= towers[1][i]?towers[1][i]:' ';
            v+= " | "
            v+= towers[2][i]?towers[2][i]:' ';
            console.log(v)
        }
    }
    view(0)
    let moves = 1,movedone,smallest = [0];
    smallest.push(dish % 2 == 0 ? 1 : 2);
    towers[smallest[smallest.length-1]].push(towers[0].pop());
    view(moves)
    while(towers[2].length < dish){
        moves++;
        movedone = false;
        for(let i in towers){
            if(movedone){break}
            if(towers[i][0]){
                for(var j in towers){
                    if(i==j || towers[i][towers[i].length-1] == 1){continue}
                    if(!towers[j][0] || towers[j][towers[j].length - 1] > towers[i][towers[i].length - 1]){ 
                        towers[j].push(towers[i].pop())
                        movedone = true;
                        view(moves)
                    }
                }
            }
        }
        moves++;
        smallest = smallest.slice(smallest.length-2);
        for(var i in towers){
            if(smallest.indexOf(parseInt(i)) == -1){
                towers[i].push(towers[smallest[smallest.length-1]].pop())
                smallest.push(parseInt(i))
                view(moves)
                break;
            }
        }
    }
}
hanoi(3)


