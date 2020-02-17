/*
    Name - Roshan Kumar
    Roll no - 1801145

    S = <C1,C2,C3,C4,C5,C6,C7,C8>
    //THE QUEEN NO. IS SAME AS THE ROW NO. OF THE QUEEN
    I= <-1,-1,-1,-1,-1,-1,-1,-1>
    A= CHOOSE A COLUMN FOR THE QUEEN AT A NON- ATTACKING POSITION
    COST = 1 "FOR EACH TRAVERSAL"
    AS COST IS 1, IT WILL WORK SIMILAR TO BFS
*/

#include <bits/stdc++.h>

using namespace std;

struct chess
{
    int queen;
    int board[8][8];
    int cost;
};

queue<chess> open;

void print(chess &c)
{
    cout<<"One of the Solution of 8 Queens Problem:-"<<endl;
    for(int i=0;i<8;i++)
    {
         for(int j=0;j<8;j++)
        {
            cout<<c.board[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
}

int check(chess &c, int j)
{
    int i = c.queen;
    int x,y;
    for(x = 0; x<8; x++)
    {
        if(c.board[i][x] == 1 || c.board[x][j] == 1)
            return 0;
    }

    int m=min(i,j);
    x = i-m;
    y = j-m;
    while(x<8 && y<8)
    {
        if(c.board[x][y] == 1)
            return 0;
        x++;
        y++;
    }

    x = y = 0;
    while(i-x>=0 && j+y<8)
    {
        if(c.board[i-x][j+y] == 1)
            return 0;
        x++;
        y++;
    }

    x = y = 0;
    while(i+x<8 && j-y>=0)
    {
        if(c.board[i+x][j-y] == 1)
            return 0;
        x++;
        y++;
    }
    return 1;
}

int main()
{
    chess c1;
    int i,j,ans=0;
    for(i=0;i<8;i++)
    {
        for(j=0;j<8;j++)
            c1.board[i][j] = 0;
    }
    c1.queen = 0;
    c1.cost=0;
    open.push(c1);
    while(!open.empty() && ans==0)
    {
        ans=0;
        chess c2 = open.front();
        open.pop();
        int a = c2.queen;
        for(j=0;j<8;j++)
        {
            if(check(c2,j)==1)
            {
                chess c3 = c2;
                c3.board[a][j] = 1;
                c3.cost++;
                c3.queen++;
                if(c3.queen == 8)
                {
                    c1=c3;
                    print(c1);
                    cout<<"Final Cost = "<<c1.cost<<endl;
                    ans=1;
                    break;
                }
                open.push(c3);
            }
        }
    }
}
