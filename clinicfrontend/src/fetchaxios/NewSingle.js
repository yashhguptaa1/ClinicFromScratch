import React from 'react';


//for iterating over every piece of data
const NewSingle = ({item}) => (
  <li>
    <p>{item.name}</p>
    <p>{item.phone}</p>
  </li>
);

export default NewSingle;
