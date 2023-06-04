import React, {useEffect, useState} from 'react';
import { Button, ButtonGroup, Container, Table,Input } from 'reactstrap';
import { Link } from 'react-router-dom';
//import APIService from './Services/APIService';


function Villes() {
    const [villes, setVilles] = useState([]);
    const [loading, setLoading] = useState(false);
    useEffect(()=>{
      setLoading(true);

      fetch('villes/all')
      .then(response => response.json())
      .then(data => {
        setVilles(data);
        setLoading(false);
      })
      
      
    }, []);
    const remove = async (id) => {
      await fetch(`villes/delete/${id}`, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }
      }).then(() => {
        let updatedVilles = [...villes].filter(i => i.id !== id);
        setVilles(updatedVilles);
      });
    }
    


    if(loading){
      return <p>Loading...</p>;
    }
    
    const villeList = villes.map(ville => {
     
        return <tr key={ville.id}>
          <td style={{whiteSpace: 'nowrap'}}>{ville.id}</td>
          <td>{ville.nom}</td>
          <td>
            <ButtonGroup>
              <Button size="sm" color="primary" tag={Link} to={"villes/" + ville.id}>Edit</Button>
              <Button size="sm" color="danger" onClick={() => remove(ville.id)}>Delete</Button>
            </ButtonGroup>
          </td>
        </tr>
      });
  
  return (
    <div>
        <Container fluid>
            <div className='float-end'>
              <Input className='mt-2' type='text'  placeholder='Search'/>
              <Button className='mt-2' color='primary' /*onClick={}*/>Search</Button>{' '}
              <Button className='mt-2' color='success' tag = {Link} to="/villes/save">Ajouter Ville</Button>
            </div>
            <h2>Liste des villes</h2>
            <Table id='bootstrapdatatable' className='table table-striped table-hover mt-3'>
                <thead>
                    <tr>
                        <th width='30%'>ID</th>
                        <th width='50%'>NOM</th>
                        <th width='20%'>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    { villeList }
                </tbody>
            </Table>
        </Container>
    </div>

  );
}
export default Villes;