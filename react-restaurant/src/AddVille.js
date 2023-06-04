import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';

function AddVille(){
  const initialFormState = {
        nom: '',
    };
  const [ville, setVille] = useState(initialFormState);
  const navigate = useNavigate();
  const { id } = useParams();
  useEffect(() => {
    if (id !== 'save') {
      fetch(`${id}`)
        .then(response => response.json())
        .then(data => setVille(data));
    }
  }, [id, setVille]);
  const handleChange = (event) => {
    const {nom, value} = event.target;
    
    setVille({ ...ville, nom : value });
  }
  const handleSubmit = async (event) => {
    event.preventDefault();

    await fetch(`${ville.id ? `${ville.id}` : ''}`, {
      method:  (ville.id) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(ville)
    });
    setVille(initialFormState);
    navigate('/');
  }

  const title = <h2>{ville.id ? 'Edit Group' : 'Add Group'}</h2>;

  return(
    <div>
        <Container>
            {title}
            <Form onSubmit={handleSubmit}>
                <FormGroup>
                    <Label htmlFor='nom'>Nom :</Label>
                    <Input type='text' name='nom' id='nom' value={ville.nom || ''} onChange={handleChange} autoComplete="nom" />
                </FormGroup>
                <FormGroup>
                <Button color="primary" type="submit">Save</Button>{' '}
                <Button color="secondary" tag={Link} to="/">Cancel</Button>
                </FormGroup>
            </Form>
        </Container>
    </div>
  )
}
export default AddVille;