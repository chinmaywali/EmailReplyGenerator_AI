
import { useState } from 'react'
import './App.css'
import { Box, Button, CircularProgress, Container, FormControl, InputLabel, MenuItem, TextField, Typography } from '@mui/material';
import { Select } from '@mui/material';
import axios from 'axios';

function App() {
  
  const [emailContent , setEmailContent] = useState('');
  const [tone , setTone] = useState('');
  const [generatedReply , setGeneratedReply ]  = useState('');
  const [loading , setLoading ]  = useState(false);
  const [error , setError]  = useState('');

  const handleSubmit = async () => {
    setLoading(true);
    setError('')
    try {
      const resp = await axios.post("http://localhost:8090/api/email/generate", {emailContent,tone});
      setGeneratedReply(typeof resp.data === 'string' ? resp.data : JSON.stringify(resp.data))
    } catch (error) {
      setError("Failed to genarateemail");
      console.error(error);
    }
    finally{
      setLoading(false);
    }
  };

  return (
    <>
      <Container maxWidth="md" sx={{py:4}}>
        <Typography variant='h3' component="h1" gutterBottom> 
          Email Reply Generator
        </Typography>
        
        <Box sx={{ mx:3}}>
          <TextField 
          fullWidth
          multiline
          rows={6}
          variant='outlined'
          label="Original email Content"
          value={emailContent || ''}
          onChange={(e)=> setEmailContent(e.target.value)} sx={{mb:2}}
          />

          <FormControl fullWidth sx={{mb:2}}>
            <InputLabel>Tone (Optional)</InputLabel>
            <Select 
              value={tone || ''}
              label={"Tone (Optional)"}
              onChange={(e)=>setTone(e.target.value)}>
               <MenuItem value="">None</MenuItem>
               <MenuItem value="Professional">Professional</MenuItem>
               <MenuItem value="Casual">Casual</MenuItem>
               <MenuItem value="Friendly">Friendly</MenuItem>
            </Select>
          </FormControl>

          <Button fullWidth sx={{mb:2}}
            varient='contained'
            onClick={handleSubmit}
            disabled={!emailContent || loading}>
            {loading ? <CircularProgress size={24}/>: "Generate Reply" }
          </Button>
        </Box>
        {error && (
          <Typography color='error' sx={{mb:2}}>
            {error}
          </Typography>
        )}

        {generatedReply && (
          <Box sx={{ mt:3}}>
            <Typography variant='h6' gutterBottom>
                Generated Reply:
            </Typography>
            <TextField fullWidth
            multiline
            rows={6}
            varient='outlined'
            value={generatedReply || ''}
            inputProps={{readOnly:true}}
            />

            <Button variant='outlined'
              sx={{mt:2}}
              onClick={()=> navigator.clipboard.writeText(generatedReply)}>
              Copy Code
            </Button>
          </Box>
        )}
      </Container>

    </>
  )
}

export default App
