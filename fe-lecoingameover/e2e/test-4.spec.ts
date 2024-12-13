import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await page.getByRole('cell', { name: '675c902fce54326ca03e82b4' }).click();
  await expect(page.getByRole('row', { name: '675c9030ce54326ca03e82d2' }).getByRole('button')).toBeVisible();
  await page.getByRole('row', { name: '675c9030ce54326ca03e82d2' }).getByRole('button').click();
  await page.getByLabel('Name:', { exact: true }).click();
  await page.getByLabel('Name:', { exact: true }).fill('Super Mario Bros.1');
  await expect(page.getByLabel('Name:', { exact: true })).toBeVisible();
  await expect(page.getByRole('button', { name: 'Update Game' })).toBeVisible();
  await page.getByRole('button', { name: 'Update Game' }).click();
  await expect(page.getByRole('cell', { name: 'Super Mario Bros.1' })).toBeVisible();
});